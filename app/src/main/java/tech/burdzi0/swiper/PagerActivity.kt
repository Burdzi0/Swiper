package tech.burdzi0.swiper

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

class PagerActivity : AppCompatActivity() {

    private lateinit var viewpager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))

        val actionBar = supportActionBar
        actionBar?.setHomeButtonEnabled(true)
        actionBar?.setDisplayHomeAsUpEnabled(true)

        initViews()
        setupViewPager()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInfl = menuInflater
        menuInfl.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    private fun initViews() {
        tabs = findViewById(R.id.tabs)
        viewpager = findViewById(R.id.viewpager)
    }

    private fun setupViewPager() {
        val adapter = MyFragmentPagerAdapter(supportFragmentManager)

        val firstFragment: MyFragment = MyFragment.newInstance(getString(R.string.sesja),
            "https://sesja.linuksowa.pl/img/ikony/jakWyglada.png")
        val secondFragment: MyFragment = MyFragment.newInstance(getString(R.string.timeAndPlace),
            "https://sesja.linuksowa.pl/img/ikony/cel.png")

        adapter.addFragment(firstFragment, "Czym jest Sesja Linuksowa?")
        adapter.addFragment(secondFragment, "Miejsce i czas wydarzenia")

        viewpager.adapter = adapter

        tabs.setupWithViewPager(viewpager)

    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_settings -> {
            val dialog = OpenInWebBrowserDialog()
            dialog.show(supportFragmentManager, "OpenInBrowserDialog")
            true
        }

        R.id.author -> {
            val intent = Intent(this, AuthorInfoActivity::class.java)
            startActivity(intent)
            true
        }

        else -> {
            this.finish()
            super.onOptionsItemSelected(item)
        }
    }



}
