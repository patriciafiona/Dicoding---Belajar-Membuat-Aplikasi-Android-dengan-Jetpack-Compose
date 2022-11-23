package com.patriciafiona.jetheroes.data

import com.patriciafiona.jetheroes.Model.Hero
import com.patriciafiona.jetheroes.Model.HeroesData

class HeroRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }

    fun searchHeroes(query: String): List<Hero>{
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}