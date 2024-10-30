package com.app.application

data class MarvelChar(
    var charName : String,
    var name: String,
    var imageRes:Int,
)

fun getAllMarvelChar() : List<MarvelChar>{
    return listOf<MarvelChar>(
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_clint),
        MarvelChar("Iron Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Captain America","Chris Evans",R.drawable.ic_captain),
        MarvelChar("Black Widow","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Hulk","Chris Hemsworth",R.drawable.ic_hulk),
        MarvelChar("Spider-Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_fst),
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_clint),
        MarvelChar("Iron Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Captain America","Chris Evans",R.drawable.ic_captain),
        MarvelChar("Black Widow","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Hulk","Chris Hemsworth",R.drawable.ic_hulk),
        MarvelChar("Spider-Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_fst),
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_clint),
        MarvelChar("Iron Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Captain America","Chris Evans",R.drawable.ic_captain),
        MarvelChar("Black Widow","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Hulk","Chris Hemsworth",R.drawable.ic_hulk),
        MarvelChar("Spider-Man","Robert `Downey", R.drawable.ic_iron),
        MarvelChar("Ther","Chris Hemsworth",R.drawable.ic_fst)
    )
}


