//package com.example.iubegresados.ui.activities
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.lifecycle.ViewModelProvider
//import com.example.iubegresados.R
//import com.example.iubegresados.util.Common
//import com.example.iubegresados.ui.viewmodels.NoteViewModel
//
//class CreateNoteActivity : AppCompatActivity() {
//
//    lateinit var noteTitleEditText: EditText
//    lateinit var notesTextLines: EditText
//    lateinit var createNoteButton: Button
//    private lateinit var noteViewModel: NoteViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_create_notes)
//
//        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
//
//        noteTitleEditText = findViewById(R.id.noteTitleEditText)
//        notesTextLines = findViewById(R.id.notesTextLines)
//        createNoteButton = findViewById(R.id.createNoteButton)
//
//        createNoteButton.setOnClickListener {
//            val title = noteTitleEditText.text.toString()
//            val content = notesTextLines.text.toString()
//
//            if (title.isEmpty() || content.isEmpty()) {
//                Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show()
//            } else {
//                // Guardar la nota en la base de datos o en algún otro lugar apropiado
//                saveNote(title, content)
//                showToast("Nota creada exitosamente")
//
//                 val intent = Intent(this, MainActivity::class.java)
//                 startActivity(intent)
//            }
//        }
//    }
//
//    private fun saveNote(title: String, content: String) {
//        // Aquí deberías implementar la lógica para guardar la nota,
//        // por ejemplo, utilizando el ViewModel y Repository.
//        noteViewModel.saveNote(title, content)
//    }
//
//    private fun showToast(message: String) {
//        Common.showToast(this, message)
//    }
//}
