package com.example.shared_preferences_sample

import android.os.Bundle
import androidx.activity.OnBackPressedDispatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.example.shared_preferences_sample.databinding.ActivityEncryptionBinding

/** ===== Tasks =====
 *
 * 1. Re-use the code written on MainActivity for the save/load functionality in
 *    the attachSaveButtonListener() and attachLoadButtonListener() functions
 *    to be re-used this class as well.
 *
 * 2. Compare the initialisation of encryptedPrefs to the regular SharedPreferences
 *    initialisation on the previous activity. Other than specifying Encryption
 *    parameters. It is quite, as the library handles all encryption internally.
 *
 * 3. Enter an email address, save it and load it as you did on the previous activity.
 *    Locate the file containing the data via the emulator's device file explorer, and
 *    inspect the content to see the encryption.
 *
 * 4. For the next set of tasks, we'll look at serializing shared preference data. Find
 *    instructions in the SerializationActivity.
 *
 * @see SerializationActivity
 */

class EncryptionActivity: AppCompatActivity() {

    private var _binding: ActivityEncryptionBinding? = null
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
            "encrypted_prefs_file",
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
        _binding = ActivityEncryptionBinding.inflate(layoutInflater)
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