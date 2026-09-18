package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    // 5. Déclarer la variable compteur et l'initialiser à 0
    private var compteur: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Charger l'interface XML
        setContentView(R.layout.activity_main)

        // 6. Récupérer les composants graphiques par leurs identifiants
        val textViewCompteur: TextView = findViewById(R.id.textViewCompteur)
        val buttonIncrementer: Button = findViewById(R.id.buttonIncrementer)
        val buttonDecrementer: Button = findViewById(R.id.buttonDecrementer)
        val buttonReinitialiser: Button = findViewById(R.id.buttonReinitialiser)

        // Fonction pour mettre à jour l'affichage et la couleur (Bonus)
        fun actualiserAffichage() {
            textViewCompteur.text = compteur.toString()

            // Amélioration facultative : Couleurs dynamiques
            when {
                compteur > 0 -> textViewCompteur.setTextColor(Color.GREEN)
                compteur < 0 -> textViewCompteur.setTextColor(Color.RED)
                else -> textViewCompteur.setTextColor(Color.BLACK)
            }
        }

        // 7. Programmer le clic sur chaque bouton
        buttonIncrementer.setOnClickListener {
            compteur++
            actualiserAffichage()
        }

        buttonDecrementer.setOnClickListener {
            compteur--
            actualiserAffichage()
        }

        buttonReinitialiser.setOnClickListener {
            compteur = 0
            actualiserAffichage()
            // Amélioration facultative : Message Toast
            Toast.makeText(this, getString(R.string.toast_reset), Toast.LENGTH_SHORT).show()
        }
        
        // Initialisation de l'affichage au démarrage
        actualiserAffichage()
    }
}