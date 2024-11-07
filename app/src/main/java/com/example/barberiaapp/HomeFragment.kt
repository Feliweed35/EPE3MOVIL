package com.example.barberiaapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.barberiaapp.ui.reservas.ReservasFragment

class HomeFragment : Fragment(R.layout.fragment_home) {

    // Se llama al crear la vista del fragmento
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Buscar los componentes en el layout
        val etUsername: EditText = view.findViewById(R.id.etUsername)
        val etPassword: EditText = view.findViewById(R.id.etPassword)
        val btnLogin: Button = view.findViewById(R.id.btnLogin)

        // Configurar el botón de inicio de sesión
        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            // Verificación básica de credenciales
            if (username == "usuario" && password == "1234") {
                // Navegar al fragmento de reservas
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, ReservasFragment())
                    .addToBackStack(null)
                    .commit()
            } else {
                // Mostrar mensaje de error si el login falla
                Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}