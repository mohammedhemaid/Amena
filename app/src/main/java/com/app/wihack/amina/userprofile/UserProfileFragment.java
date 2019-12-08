package com.app.wihack.amina.userprofile;

import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.app.wihack.amina.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;


@EFragment(R.layout.fragment_add_emergency_data)
public class UserProfileFragment extends Fragment {

    @ViewById(R.id.user_name_edit_text) EditText mUserNameEditText;
    @ViewById(R.id.age_edit_text) EditText mAgeEditText;
    @ViewById(R.id.children_no_edit_text) EditText mChildrenNoEditText;
    private FirebaseFirestore mDb;


    public UserProfileFragment() {
        // Required empty public constructor
    }

    @AfterViews
    public void after() {
        mDb = FirebaseFirestore.getInstance();
        DocumentReference docRef = mDb.collection("users").document("1");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    UserProfile userProfile = task.getResult().toObject(UserProfile.class);
                    if (userProfile != null) {
                        mUserNameEditText.setText(userProfile.getUsername());
                        mAgeEditText.setText(String.valueOf(userProfile.getAge()));
                        mChildrenNoEditText.setText(String.valueOf(userProfile.getChildren_number()));
                    }

                }
            }
        });

    }
}