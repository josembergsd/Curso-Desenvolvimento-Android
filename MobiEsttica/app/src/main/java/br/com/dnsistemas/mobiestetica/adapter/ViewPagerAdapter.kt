package br.com.dnsistemas.mobiestetica.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import br.com.dnsistemas.mobiestetica.fragments.CallFagment
import br.com.dnsistemas.mobiestetica.fragments.StatusFragment
import br.com.dnsistemas.mobiestetica.fragments.TalkFragment

class ViewPagerAdapter(fa: FragmentActivity): FragmentStateAdapter(fa) {

    private val talkFragment = TalkFragment()
    private val statusFagment = StatusFragment()
    private val callsFragment = CallFagment()

    //Retorna o número de fragmentos adicionados pela fun addFragment()
    override fun getItemCount() = 3

    //Cria os fragmentos pelas posições
    override fun createFragment(position: Int): Fragment =
        when (position) {
            0 -> talkFragment
            1 -> statusFagment
            else -> callsFragment
    }
}