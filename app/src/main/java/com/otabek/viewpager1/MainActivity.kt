package com.otabek.viewpager1

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.otabek.viewpager1.Adapter.MyInfoAdapter
import com.otabek.viewpager1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var list: ArrayList<MyInfo>
    lateinit var myInfoAdapter: MyInfoAdapter
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var indicators: Array<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        list = ArrayList()
        list.add(MyInfo("Click va Paymega o'tish xizmati", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.", R.drawable.image1))
        list.add(MyInfo("Barcha operatorlar bo'yicha statistika", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.", R.drawable.image2))
        list.add(MyInfo("Tariflarni filtirlash", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.", R.drawable.image3))
        list.add(MyInfo("Yangi imkoniyatlar", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pulvinar aliquam at donec facilisis. Lacus, justo, volutpat, diam condimentum ipsum, faucibus rutrum.", R.drawable.image2))

        myInfoAdapter = MyInfoAdapter(list)
        binding.viewPager.adapter = myInfoAdapter

        indicators = arrayOf(binding.indicator1, binding.indicator2, binding.indicator3, binding.indicator4)

        setCurrentIndicator(0)


        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })

        binding.nextText.setOnClickListener { nextPage() }
        binding.otkazish.setOnClickListener { nextPage() }
    }

    private fun setCurrentIndicator(index: Int) {
        indicators.forEachIndexed { i, view ->
            if (i == index) {
                view.setBackgroundResource(R.drawable.indicator_active)
            } else {
                view.setBackgroundResource(R.drawable.indicator_inactiv)
            }
        }
    }
    private fun nextPage() {
        val currentItem = binding.viewPager.currentItem
        if (currentItem < myInfoAdapter.itemCount - 1) {
            binding.viewPager.currentItem = currentItem + 1
        }
    }
}
