package io.github.ziginsider.epam_laba_9

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.github.ziginsider.epam_laba_9.model.Character
import io.github.ziginsider.epam_laba_9.utils.toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*

/**
 * Сontains Fragment that is selected through Menu of Navigation Drawer
 *
 * @author Alex Kisel
 * @since 2018-04-05
 */
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
        RecyclerViewFragment.ItemClickEventListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
                this,
                drawer_layout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        navigation_view.setNavigationItemSelectedListener(this)
        setNavigationDrawerHeader()
        showFragment(RecyclerViewFragment())
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_fragment_first -> {
                showFragment(RecyclerViewFragment())
            }
            R.id.nav_fragment_second -> {
                showFragment(RecyclerViewFragment())
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit()
    }

    private fun setNavigationDrawerHeader() {
        val v = navigation_view.inflateHeaderView(R.layout.header_layout)
        val img = v.findViewById(R.id.image_view_header) as ImageView
        Glide.with(img.context)
                .load(resources.getString(R.string.url_one))
                .into(img)
    }

    override fun onFragmentItemClick(item: Character) {
        toast("I'm ${item.name} !")
    }


}
