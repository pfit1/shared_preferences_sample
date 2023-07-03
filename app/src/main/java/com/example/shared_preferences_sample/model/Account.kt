package com.example.shared_preferences_sample.model

import kotlinx.serialization.Serializable

@Serializable
data class Account(
    var email: String? = null,
    var givenName: String? = null,
    var familyName: String? = null
)
