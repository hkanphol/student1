package th.ac.kku.cis.student

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import th.ac.kku.cis.student.ui.theme.StudentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentTheme {
                // A surface container using the 'background' color from the theme
                StudentApp()
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudentApp(){
    var viewModel = StudentViewModel()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Student App")},
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    viewModel.addStudent(
                        "New student",
                        "Student ID") },
                containerColor = Color.LightGray,
                contentColor = Color.Black) {
                Icon(Icons.Filled.Add,
                    "Add new student")
            }
        }
    ){
        LazyColumn(
            modifier = Modifier.padding(it)){
            items(viewModel.data){
                    item->Text(item.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    StudentTheme {
        StudentApp()
    }
}