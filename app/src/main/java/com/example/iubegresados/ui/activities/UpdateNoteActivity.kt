//package com.example.iubegresados.ui.activities
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.ImageView
//import android.widget.Toast
//import androidx.lifecycle.ViewModelProvider
//import com.example.iubegresados.R
//import com.example.iubegresados.data.model.UserModel
//import com.example.iubegresados.ui.viewmodels.NoteViewModel
//
//class UpdateNoteActivity : AppCompatActivity() {
//    private lateinit var noteViewModel: NoteViewModel
//    private lateinit var noteTitleEditText: EditText
//    private lateinit var notesTextLines: EditText
//    private var noteId: Long = 0
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_update_note)
//
//        noteViewModel = ViewModelProvider(this).get(NoteViewModel::class.java)
//
//        noteTitleEditText = findViewById(R.id.noteTitleEditText)
//        notesTextLines = findViewById(R.id.notesTextLines)
//
//        // Obtener el ID de la nota del intent
//        noteId = intent.getLongExtra("note_id", 0)
//
//        // Obtener la nota correspondiente al ID
//        noteViewModel.noteFromDb.observe(this, { note ->
//            // Mostrar los detalles de la nota en los campos de texto
//            noteTitleEditText.setText(note.title)
//            notesTextLines.setText(note.content)
//        })
//
//        // Manejar el clic del botón de actualización
//        findViewById<Button>(R.id.updateNoteButton).setOnClickListener {
//            updateNote()
//        }
//
//        // Manejar el clic del botón de regreso
//        findViewById<ImageView>(R.id.updateNoteBackButton).setOnClickListener {
//            finish()
//        }
//    }
//
//    private fun updateNote() {
//        val title = noteTitleEditText.text.toString().trim()
//        val content = notesTextLines.text.toString().trim()
//
//        if (title.isNotEmpty() && content.isNotEmpty()) {
//            val updatedNote = UserModel(noteId, title, content)
//            noteViewModel.updateNote(updatedNote)
//            Toast.makeText(this, "Nota actualizada correctamente", Toast.LENGTH_SHORT).show()
//            finish() // Cerrar la actividad después de la actualización
//        } else {
//            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
//        }
//    }
//}
