package com.example.mad_practicalexam_22012011038


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mad_practicalexam_22012011038.ui.theme.MADPracticalexam22012011038Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADPracticalexam22012011038Theme()
            {
                EventDetailsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventDetailsScreen() {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("EventEase") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back action */ }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    IconButton(onClick = { /* Handle share action */ }) {
                        Icon(Icons.Filled.Share, contentDescription = "Share")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp)
        ) {
            // Header Image
            Image(
                painter = painterResource(id = R.drawable.event), // Replace with your drawable
                contentDescription = "Event Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))
            IconButton(onClick = { /* Handle back action */ }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
            IconButton(onClick = { /* Handle share action */ }) {
                Icon(Icons.Filled.Share, contentDescription = "Share")
            }
            Icon(Icons.Filled.Star, contentDescription = "Star", tint = Color.Yellow)

            // Event Title and Description
            Text(
                text = "Tech Conference 2024",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Mehsana, Gujarat | 2.5 km away",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray
            )
            Text(
                text = "This is a detailed description of the event...",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Event Schedule
            Text(
                text = "Event Schedule",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            LazyRow(
                modifier = Modifier.padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(listOf("Keynote Speech", "Networking Session", "Closing Ceremony")) { session ->
                    EventScheduleCard(session)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Reviews Section
            Text(
                text = "Reviews",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(vertical = 8.dp)
            ) {
                ReviewItem("Alice Johnson", 4, "Great event! Well-organized and informative.")
                ReviewItem("Bob Smith", 5, "Really enjoyed the keynote speaker. Would recommend!")
                ReviewItem("Charlie Davis", 3, "Good event overall, but some sessions were too short.")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { /* Handle Buy Tickets */ }, modifier = Modifier.weight(1f)) {
                    Text("Buy Tickets")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { /* Handle Add to Calendar */ },
                    modifier = Modifier.weight(1f),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                ) {
                    Text("Add to Calendar")
                }
            }
        }
    }
}

@Composable
fun EventScheduleCard(title: String) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(150.dp)
            .height(80.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title, style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Center)
        }
    }
}

@Composable
fun ReviewItem(name: String, rating: Int, review: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.user), // Replace with your drawable
            contentDescription = "User Avatar",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(Color.Gray)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = name, fontWeight = FontWeight.Bold)
            Row {
                repeat(rating) { Icon(Icons.Filled.Star, contentDescription = "Star", tint = Color.Yellow) }
                repeat(5 - rating) { Icon(Icons.Filled.Star, contentDescription = "Empty Star", tint = Color.Gray) }
            }
            Text(text = review, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EventDetailsScreenPreview() {
    MADPracticalexam22012011038Theme()
    {
        EventDetailsScreen()
    }
}