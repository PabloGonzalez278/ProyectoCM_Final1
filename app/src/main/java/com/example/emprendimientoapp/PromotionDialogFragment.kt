package com.example.emprendimientoapp

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

class PromotionDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext())
            .setTitle("¡Felicidades!")
            .setMessage("Te has ganado un 20% de descuento en tu compra.")
            .setPositiveButton("Aplicar") { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }
}