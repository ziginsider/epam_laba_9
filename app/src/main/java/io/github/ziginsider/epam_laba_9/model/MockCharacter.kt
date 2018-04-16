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
        characters.add(Character(0, res.getString(R.string.caesar_name),
                res.getString(R.string.caesar_date)))
        characters.add(Character(1, res.getString(R.string.augustus_name),
                res.getString(R.string.augustus_date)))
        characters.add(Character(2, res.getString(R.string.caligula_name),
                res.getString(R.string.caligula_date)))
        characters.add(Character(3, res.getString(R.string.claudius_name),
                res.getString(R.string.claudius_date)))
        characters.add(Character(4, res.getString(R.string.tiberius_name),
                res.getString(R.string.tiberius_date)))
        characters.add(Character(5, res.getString(R.string.nero_name),
                res.getString(R.string.nero_date)))
        characters.add(Character(6, res.getString(R.string.galba_name),
                res.getString(R.string.galba_date)))
        characters.add(Character(7, res.getString(R.string.otho_name),
                res.getString(R.string.otho_date)))
        characters.add(Character(8, res.getString(R.string.vitelius_name),
                res.getString(R.string.vitelius_date)))
        characters.add(Character(9, res.getString(R.string.vespasian_name),
                res.getString(R.string.vespasian_date)))
        characters.add(Character(10, res.getString(R.string.titus_name),
                res.getString(R.string.titus_date)))
        characters.add(Character(11, res.getString(R.string.domitian_name),
                res.getString(R.string.domitian_date)))
        return characters
    }
}