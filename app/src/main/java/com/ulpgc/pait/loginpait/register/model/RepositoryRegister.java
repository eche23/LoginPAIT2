package com.ulpgc.pait.loginpait.register.model;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ulpgc.pait.loginpait.register.events.RegisterEvent;
import com.ulpgc.pait.loginpait.user.User;

import org.greenrobot.eventbus.EventBus;



public class RepositoryRegister implements IRepositoryRegister{

    private FirebaseAuth mAuth;

    public RepositoryRegister() {
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void register(final String email, String password, final String name) {
        try {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(Task<AuthResult> task) {
                            if (task.isSuccessful()) {

                                // Sign in success, update UI with the signed-in user's information

                                FirebaseDatabase database = FirebaseDatabase.getInstance();

                                DatabaseReference ref = database.getReference().child("usuarios");
                                String key = ref.push().getKey();
                                User user = new User ();
                                user.setId(key);
                                user.setName(name);
                                user.setEmail(email);
                                ref.child(key).setValue(user);


                                postEvents(RegisterEvent.ON_REGISTER_SUCESS);
                            } else {
                                String console = "Error al crear";
                                // If sign in fails, display a message to the user.
                                postEvents(RegisterEvent.ON_REGISTER_ERROR);
                            }
                        }
                    });
        } catch (Exception e) {
            String console = "Error";
            postEvents(RegisterEvent.ON_REGISTER_ERROR);
        }

    }

    private void postEvents(int type) {
        RegisterEvent event = new RegisterEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);

    }
}
