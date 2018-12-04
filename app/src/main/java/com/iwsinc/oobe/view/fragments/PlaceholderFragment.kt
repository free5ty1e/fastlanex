package com.example.fastlanex.view.fragments

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fastlanex.R
import com.example.fastlanex.viewmodel.UserProfileViewModel
import kotlinx.android.synthetic.main.fragment_settings.*
import org.koin.android.ext.android.inject


class PlaceholderFragment : Fragment() {
    private val viewModel: UserProfileViewModel by inject()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val userId = arguments!!.getString(UID_KEY)
        Log.d(javaClass.simpleName, ".onActivityCreated(): userID retrieved from arguments: $userId")
        settings_message.text = "Placeholder fragment for $userId"

        viewModel.init(userId!!)

        //View handling
        viewModel.user?.observe(this, Observer {
            //Update UI
            val origMsg = settings_message.text
            val firstNameOrNull = it?.firstName ?: "null"
            settings_message.text = "$origMsg $firstNameOrNull"
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_placeholder, container, false)
    }

    companion object {
        private const val UID_KEY = "uid"

        fun newInstance(userId: String): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putString(UID_KEY, userId)
            fragment.arguments = args
            return fragment
        }
    }
}