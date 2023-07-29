package br.com.dnsistemas.appbasekotlin.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import br.com.dnsistemas.appbasekotlin.databinding.FragmentCadastroVeiculoBinding

class CadastroVeiculoFragment : Fragment() {

    private var _binding: FragmentCadastroVeiculoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cadastroVeiculoViewModel =
            ViewModelProvider(this).get(CadastroVeiculoViewModel::class.java)

        _binding = FragmentCadastroVeiculoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        cadastroVeiculoViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}