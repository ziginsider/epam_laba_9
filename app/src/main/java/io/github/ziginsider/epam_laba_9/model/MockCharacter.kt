package io.github.ziginsider.epam_laba_9.model

import android.content.res.Resources
import io.github.ziginsider.epam_laba_9.R

/**
 * Generates list of characters
 *
 * @see {@link Character}
 *
 * @author Alex Kisel
 * @since 2018-04-03
 */
class MockCharacter(val res: Resources) {
    /**
     * Generates list of characters {@link model#Character}
     *
     * @return list of characters
     */
    fun generateStarWarsCharacters(): List<Character> {
        val characters = ArrayList<Character>()
        characters.add(Character(0, res.getString(R.string.yoda_name),
                res.getString(R.string.yoda_description)))
        characters.add(Character(1, res.getString(R.string.luk_name),
                res.getString(R.string.luk_description)))
        characters.add(Character(2, res.getString(R.string.princess_name),
                res.getString(R.string.princess_description)))
        characters.add(Character(3, res.getString(R.string.han_name),
                res.getString(R.string.han_description)))
        characters.add(Character(4, res.getString(R.string.chewbacca_name),
                res.getString(R.string.chewbacca_description)))
        characters.add(Character(5, res.getString(R.string.darth_name),
                res.getString(R.string.darth_description)))
        characters.add(Character(6, res.getString(R.string.r2_name),
                res.getString(R.string.r2_description)))
        characters.add(Character(7, res.getString(R.string.c_name),
                res.getString(R.string.c_description)))
        return characters
    }
}