package io.github.droidkaigi.confsched2018.presentation.sponsors


import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.github.droidkaigi.confsched2018.R
import io.github.droidkaigi.confsched2018.databinding.ActivitySponsorsBinding
import io.github.droidkaigi.confsched2018.presentation.NavigationController
import javax.inject.Inject

class SponsorsActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject lateinit var navigationController: NavigationController

    private val binding: ActivitySponsorsBinding by lazy {
        DataBindingUtil.setContentView<ActivitySponsorsBinding>(this, R.layout.activity_sponsors)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        navigationController.navigateToSponsors()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, SponsorsActivity::class.java))
        }
    }
}
