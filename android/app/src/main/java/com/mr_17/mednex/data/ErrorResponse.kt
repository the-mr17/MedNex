package com.mr_17.mednex.data


import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error")
    val error: Error,
    @SerializedName("message")
    val message: String
) {
    data class Error(
        /*@SerializedName("errors")
        val errors: Errors,*/
        @SerializedName("_message")
        val _message: String,
        @SerializedName("message")
        val message: String,
        @SerializedName("name")
        val name: String
    ) {
        /*data class Errors(
            @SerializedName("username")
            val username: Username
        ) {
            data class Username(
                @SerializedName("kind")
                val kind: String,
                @SerializedName("message")
                val message: String,
                @SerializedName("name")
                val name: String,
                @SerializedName("path")
                val path: String,
                @SerializedName("properties")
                val properties: Properties,
                @SerializedName("value")
                val value: String
            ) {
                data class Properties(
                    @SerializedName("message")
                    val message: String,
                    @SerializedName("path")
                    val path: String,
                    @SerializedName("regexp")
                    val regexp: Regexp,
                    @SerializedName("type")
                    val type: String,
                    @SerializedName("value")
                    val value: String
                ) {
                    class Regexp
                }
            }
        }*/
    }
}