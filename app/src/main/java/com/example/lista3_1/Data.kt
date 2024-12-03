package com.example.lista3_1

import kotlin.random.Random

data class Exercise(
    val content: String,
    val points: Int
)

data class Subject(
    val name: String
)

data class ExerciseList(
    val exercises: MutableList<Exercise>,
    val subject: Subject,
    val grade: Float
)

object DataGenerator {

    private val subjects = listOf(
        Subject("Matematyka"),
        Subject("PUM"),
        Subject("Fizyka"),
        Subject("Elektronika"),
        Subject("Algorytmy")
    )

    fun generate(): List<ExerciseList> {
        val exerciseLists = mutableListOf<ExerciseList>()

        repeat(20) {
            val randomSubject = subjects.random()
            val randomGrade = Random.nextFloat().let { (it * 4).toInt() * 0.5f + 3.0f }
            val randomExercisesCount = Random.nextInt(1, 11)

            val exercises = mutableListOf<Exercise>()
            repeat(randomExercisesCount) { index ->
                exercises.add(
                    Exercise(
                        content = "Lorem ipsum zadanie ${index + 1}, ${generateLoremIpsum()}",
                        points = Random.nextInt(1, 11)
                    )
                )
            }

            exerciseLists.add(
                ExerciseList(
                    exercises = exercises,
                    subject = randomSubject,
                    grade = randomGrade
                )
            )
        }

        return exerciseLists
    }

    private fun generateLoremIpsum(): String {
        val loremOptions = listOf(
            "dolor sit amet.",
            "consectetur adipiscing elit.",
            "sed do eiusmod tempor incididunt.",
            "ut labore et dolore magna aliqua.",
            "Ut enim ad minim veniam."
        )
        return loremOptions.random()
    }
}
