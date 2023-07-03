package com.example.shared_preferences_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shared_preferences_sample.databinding.ActivityMainBinding


/** ===== Tasks =====
 *
 * 1. Add logic to the attachSaveButtonListener() function to the use the
 *    [sharedPrefs] object and save the email address as a
 *    key-value pair.
 *
 * 2. Complete the attachLoadButtonListener() function by attaching an
 *    onClickListener to the load button (binding.btnLoad). This listener should
 *    load the value attached to te key you provide in step 1, using the
 *    [sharedPrefs] object again.
 *
 * 3. Building on the code written for step 2, we now want the text loaded from
 *    shared preferences to be displayed in the TextView named tvLoadedEmail when
 *    it is loaded. -- Hint: You can access this TextView via binding.tvLoadedEmail.
 *
 * 4. a. Run the emulator and confirm that your code is working by saving your input,
 *       then loading it and confirming that it matches what you saved.
 *
 *    b. With the emulator running, go to the device manager (tab on the right-hand side
 *       of the Android Studio window), and click the 'file' icon for your emulator (in the
 *       Actions column). In the device file explorer that opens up, locate the file in
 *       which your preferences were saved, and open it to see what the stored data looks
 *       like. What format is it stored in?
 *
 * 5. You would have noticed that the preferences data is human-readable, and is not
 *    encrypted. The next tasks look at encrypting shared preference data. Find
 *    instructions in EncryptionActivity.
 *
 * @see EncryptionActivity
 */

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private val sharedPrefs by lazy {
        getSharedPreferences(
            "shared_prefs_file",
            MODE_PRIVATE
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Creates a view binding. It binds the UI to the binding variable,
         * enabling simple access to the UI (created in XML) from Kotlin code.
         */
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setNavigationListeners()

        attachSaveButtonListener()
        attachLoadButtonListener()

    }

    private fun attachSaveButtonListener() {

        binding.btnSave.setOnClickListener {
            /** The following line stores the input from the email address EditText in
             * into a String variable. */
            val email = binding.etEmailAddress.text.toString()


            // TODO: Complete step 1 here

            /*  Hint: to save/load in shared preferences, use:
             *  sharedPrefs.edit().{save/load function} */
        }

    }

    private fun attachLoadButtonListener() {
        // TODO: Complete step 2 here
    }


    private fun setNavigationListeners() {

        // Button listener: navigate to EncryptionActivity
        binding.btnGoToEncryption.setOnClickListener {
            val intent = Intent(this, EncryptionActivity::class.java)
            startActivity(intent)
        }

        // Button listener: navigate to SerializationActivity
        binding.btnGoToSerialization.setOnClickListener {
            val intent = Intent(this, SerializationActivity::class.java)
            startActivity(intent)
        }

    }

}