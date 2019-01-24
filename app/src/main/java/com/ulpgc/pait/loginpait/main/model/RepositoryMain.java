/*package com.ulpgc.pait.loginpait.main.model;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ulpgc.pait.loginpait.main.events.MainEvent;
import com.ulpgc.pait.loginpait.user.User;

import org.greenrobot.eventbus.EventBus;

public class RepositoryMain implements IRepositoryMain {

    private FirebaseUser user;
    private DatabaseReference userUpdate;

    public RepositoryMain() {
        //TODO: Obtener la referencia a Firebase
       user = FirebaseAuth.getInstance().getCurrentUser();
       userUpdate = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void loadData(final String email) {
        DatabaseReference usuario = FirebaseDatabase.getInstance().getReference();
        usuario.child("users").orderByChild("email").equalTo(email).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    User usuario = new User();
                    usuario.setName(data.child("name").getValue().toString());
                    usuario.setId(data.child("id").getValue().toString());
                    usuario.setEmail(data.child("email").getValue().toString());
                    postEvents(MainEvent.SUCCESS_DATA_GET_FROM_DB, usuario);
                }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                postEvents(MainEvent.FAIL_DATA_GET_FROM_DB);
            }
        });

    }

    @Override
    public void updateData(String id, String name) {
        final DatabaseReference usuario = FirebaseDatabase.getInstance().getReference();
        usuario.child("users").orderByChild(id).equalTo(id);
        usuario.child("users").child(id).child("name").setValue(name);
        usuario.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    postEvents(MainEvent.UPDATE_SUCCESS);
                }

            }

            @Override
            public void onCancelled( DatabaseError databaseError) {
                postEvents(MainEvent.UPDATE_ERROR);
            }
        });
    }

    @Override
    public void deleteData (String id) {
        DatabaseReference usuario = FirebaseDatabase.getInstance().getReference().child("users").child(id);
        usuario.removeValue();
        this.user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    //TODO: Borrado Correcto
                    postEvents(MainEvent.DELETE_SUCCESS);
                } else {
                    //TODO: Error al Borrar
                    postEvents(MainEvent.DELETE_ERROR);
                }
            }
        });

    }

    @Override
    public void logOut () {
        FirebaseAuth.getInstance().signOut();
        //TODO: Notificar que se ha deslogueado
        postEvents(MainEvent.LOGOUT_SUCCESS);
    }

    private void postEvents(int type, User usuario) {
        MainEvent event = new MainEvent();
        event.setEventType(type);
        event.setUsuario(usuario);
        EventBus.getDefault().post(event);
    }

    private void postEvents(int type) {
        MainEvent event = new MainEvent();
        event.setEventType(type);
        EventBus.getDefault().post(event);
    }


}*/
