package com.cs.movieapp.ui.watch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs.movieapp.R
import com.cs.movieapp.databinding.FragmentWatchNowBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class WatchNowFragment : Fragment() {

    private var _binding: FragmentWatchNowBinding? =null
    private val binding by lazy { _binding!! }
    @Inject
    lateinit var adapter: WatchNowAdapter
    private val todoViewModel: WatchNowViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= DataBindingUtil.inflate(inflater,R.layout.fragment_watch_now,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initViewModels()
    }

    private fun initViews(){

        binding.movieRv.adapter=adapter
        val gridLayoutManager = GridLayoutManager(context,2 )
        binding.movieRv.layoutManager= gridLayoutManager

    }

    private fun initViewModels(){

        todoViewModel.movieData.observe(viewLifecycleOwner) {
            println("OOO${it}")
            adapter.submitList(it)
        }

//        todoViewModel.errorMessage.observe(viewLifecycleOwner) {
//            Toast.makeText(context, getString(R.string.no_elements), Toast.LENGTH_SHORT).show()
//        }

        todoViewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBar.visibility = View.VISIBLE
            } else {
                binding.progressBar.visibility = View.GONE
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding =null
    }

}