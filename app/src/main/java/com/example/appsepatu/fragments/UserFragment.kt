package com.example.appsepatu.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appsepatu.LoginActivity
import com.example.appsepatu.databinding.FragmentUserBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_user.*


class UserFragment : Fragment() {

    private var _binding: FragmentUserBinding? = null
    lateinit var auth: FirebaseAuth

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  FragmentUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser

        id_txt.text = user?.uid
        name_txt.text = user?.displayName
        email_txt.text = user?.email


        binding.btnLogout.setOnClickListener{
            tombolkeluar()
        }
    }

    private fun tombolkeluar() {
        auth = FirebaseAuth.getInstance()
        auth.signOut()
        val i = Intent(context, LoginActivity::class.java)
        startActivity(i)
        activity?.finish()
    }

}