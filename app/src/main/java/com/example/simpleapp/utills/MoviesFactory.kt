package com.example.simpleapp.utills

import com.example.simpleapp.data.ItemMovie

object MoviesFactory {

    private val listNameMovies = listOf<String>(
        "Лобстер",
        "Трудности перевода Last of us 2",
        "Хобит",
        "Бакуган новая Вестория",
        "Афро самурай",
        "Ведьмак Дикая охота",
        "Я на рыбалке(любительское)",
        "А зори здесь тихие",
        "T-34",
        "Как я встретил вашу маму",
        "Валли",
        "MTV - главный канал нашего детства / вДудь",
        "Главное расследование года",
        "От динозавров к Jetpack Compose",
        "Солярис",
        "PELINAL (ANIMATED OPERA)",
        "Tes 6 Teaser",
        "Заводной апельсин",
        "yakuza 0 movie cutscenes",
        "Стримушка ТВ, выпуск 181",
        "Batman snider cut",
    ).shuffled()

    private val listOfGenres = listOf<String>(
        "Комедия",
        "Хоррор",
        "Мелодрама",
        "Документальный фильм",
        "Хронологические события",
        "Жесть",
        "Трагедия",
        "Slice of life",
        "Научная фантастика",
        "Фентези",
        "Аниме",
        "Экшон",
        "Из ютубчика",
    ).shuffled()

    private fun getRating() = (0..10).random()

    private fun getGenresId() = (listOfGenres.indices).random()

    fun createListMovies(): List<ItemMovie> {
        return MutableList(20) {
            ItemMovie(listNameMovies[it], listOfGenres[getGenresId()], "${getRating()}")
        }
    }
}