package backend.api.models.examples

import io.qameta.allure.Step

data class ExampleName(
    val first: String,
    val last: String,
    val title: String
)

class PostExamples {
    companion object {

        @Step("Get default Name request")
        fun defaultNameRequest(first: String, last: String = "TEST"): ExampleName {
            return ExampleName(
                first = first,
                last = last,
                title = "SOME TITLE"
            )
        }
    }
}