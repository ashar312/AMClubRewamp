package com.project.techaract.amclub.Utils;

import com.google.firebase.firestore.FirebaseFirestore;

public class References {
    FirebaseFirestore firebaseFirestore;

    public References(){
        firebaseFirestore = FirebaseFirestore.getInstance();
    }

    public FirebaseFirestore getFirebaseFirestore() {
        return firebaseFirestore;
    }
}
