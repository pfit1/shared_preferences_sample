package com.example.shared_preferences_sample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.shared_preferences_sample.databinding.ActivitySerializationBinding

/** ===== Tasks =====
 *
 * 1. Re-use the code you wrote to implement the listeners for the save and
 *    load buttons.
 *
 * 2. View the activity_serialization.xml layout, and you will see that there
 *    are three input fields. Add code to the save button listener to extract
 *    the input from all three text input fields, and use the strings to
 *    initialised an object (refer to the Account data class in the .model package).
 *    -- Hint: You can to inspect the XML to find the id's of the input fields.
 *
 * 3. The Account data class is annotated with @Serializable. This means it can be
 *    encoded to and from JSON using Kotlin functions. In the save button listener, you
 *    must convert the object to a JSON string before it can be saved in a text. Find
 *    the function for the kotlinx.serialization library that converts an object to a
 *    JSON formatted string.
 *
 * 4. To load the account, we will generally convert the Account from a JSON string
 *    to an Account object using another kotlinx.serialization function. In this case,
 *    simply display the String in JSON format in the TextView.
 *
 *
 * That concludes the basics of implementing EncryptedSharedPreferences. If you want
 * to see how we implement it at scale, refer to the Android IPC application to see
 * how we've moved the functions to their own separate class(es) to prevent code
 * duplication and make a good portion of the code re-usable across projects.
 *
 */

class SerializationActivity : AppCompatActivity() {

        private var _binding: ActivitySerializationBinding? = null
        private val binding get() = _binding!!

    // This generates a MasterKey to use for our encrypted preferences object
    private val masterKey by lazy {
        MasterKey.Builder(this, MasterKey.DEFAULT_MASTER_KEY_ALIAS)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build()
    }

    private val encryptedPrefs by lazy {
        EncryptedSharedPreferences.create(
            this,
            "encrypted_account_prefs",
            masterKey,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )
    }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            /**
             * Creates a view binding. It binds the UI to the binding variable,
             * enabling simple access to the UI (created in XML) from Kotlin code.
             */
            _binding = ActivitySerializationBinding.inflate(layoutInflater)
            val view = binding.root
            setContentView(view)
            binding.btnBack.setOnClickListener { finish() }

            attachSaveButtonListener()
            attachLoadButtonListener()

        }

    private fun attachSaveButtonListener() {

        binding.btnSave.setOnClickListener {
            /** The following line stores the input from the email address EditText in
             * into a String variable. */
            val email = binding.etEmailAddress.text.toString()

            // TODO: Copy and paste code from MainActivity
        }

    }

    private fun attachLoadButtonListener() {

        // TODO: Copy and paste code from MainActivity

    }
}