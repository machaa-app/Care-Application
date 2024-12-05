package com.care

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MenuScreen(onNavigate: (String) -> Unit) {
    var selectedMenuItem by remember { mutableStateOf<String?>(null) } // Track the selected menu item

    // Top App Bar with custom icon and bold "C" as the title
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = "C",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,  // Make it bold
                    fontSize = 24.sp,  // Adjust the size of the letter "C"
                    color = Black // Color of the text
                )
            )
        },
        navigationIcon = {
            // Custom icon with letter "C" inside a circle
            Box(
                modifier = Modifier
                    .size(40.dp)  // Icon size
                    .background(Color.Blue, CircleShape)
                    .padding(8.dp),  // Padding inside the circle
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "C",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold, // Make the "C" bold
                        fontSize = 20.sp,// Adjust the font size for the "C"
                        color = Black // White text color for contrast
                    )
                )
            }
        }
    )

    // Show the content for the selected menu item
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)  // Green background
            .padding(16.dp)
    ) {
        if (selectedMenuItem != null) {
            when (selectedMenuItem) {
                "home" -> HomeContent(onBack = { selectedMenuItem = null })
                "services" -> ServicesContent(onBack = { selectedMenuItem = null })
                "diseases" -> DiseasesContent(onBack = { selectedMenuItem = null })
                "learning" -> LearningContent(onBack = { selectedMenuItem = null })
                "health_records" -> HealthRecordsContent(onBack = { selectedMenuItem = null })
                "doctors_directory" -> DoctorsDirectoryContent(onBack = { selectedMenuItem = null })
                "contact_us" -> ContactUsContent(onBack = { selectedMenuItem = null })
            }
        } else {
            @Composable
            fun MenuButton(
                text: String,
                iconResId: Int,  // Change this to accept the resource ID for the custom icon
                isSelected: Boolean,
                onClick: () -> Unit
            ) {
                Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .height(56.dp)  // Adjust button height as needed
                ) {
                    // Load the custom icon using painterResource
                    Image(
                        painter = painterResource(id = iconResId),  // Load the icon using the passed resource ID
                        contentDescription = text,
                        modifier = Modifier
                            .size(100.dp)
                            .padding(end =12.dp)
                    )
                    Text(text = text, style = MaterialTheme.typography.bodyLarge)
                }
            }

            // Default Menu Buttons with custom icons
            LazyColumn(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    MenuButton("Home", R.drawable.iconshh, selectedMenuItem == "home") {
                        selectedMenuItem = "home"
                        onNavigate("home")
                    }
                }
                item {
                    MenuButton("Services", R.drawable.iconsss , selectedMenuItem == "services") {
                        selectedMenuItem = "services"
                        onNavigate("services")
                    }
                }
                item {
                    MenuButton("Diseases", R.drawable.coronavirus, selectedMenuItem == "diseases") {
                        selectedMenuItem = "diseases"
                        onNavigate("diseases")
                    }
                }
                item {
                    MenuButton("Learning", R.drawable.study, selectedMenuItem == "learning") {
                        selectedMenuItem = "learning"
                        onNavigate("learning")
                    }
                }
                item {
                    MenuButton("Health Records", R.drawable.medical, selectedMenuItem == "health_records") {
                        selectedMenuItem = "health_records"
                        onNavigate("health_records")
                    }
                }
                item {
                    MenuButton("Doctors Directory", R.drawable.doctor, selectedMenuItem == "doctors_directory") {
                        selectedMenuItem = "doctors_directory"
                        onNavigate("doctors_directory")
                    }
                }
                item {
                    MenuButton("Contact Us", R.drawable.contact, selectedMenuItem == "contact_us") {
                        selectedMenuItem = "contact_us"
                        onNavigate("contact_us")
                    }
                }
            }
        }
    }
}
// Back button composable to navigate back to the menu
@Composable
fun BackButton(onBack: () -> Unit) {
    IconButton(onClick = onBack) {
        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
    }
}

@Composable
fun HomeContent(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()) // Vertical scrolling
    ) {
        // Back Button
        BackButton(onBack = onBack)

        // Home Image
        Image(
            painter = painterResource(id = R.drawable.oome),
            contentDescription = "Home Image",
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Title text
        Text(
            text = "WELCOME TO CARE!",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Paragraph Content
        Text(
            text = """
                With so many advances in technology,it's no surprise that mobile application has 
                become an important channel for healthcare marketers.One of the biggest trends in
                healthcare in 2024 is increased access to data.The healthcare industry is a massive
                market,and the adoption of mobile application by hospitals is growing quickly.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph Content
        Text(
            text = """
                In today's digital age,mobile application has become an essential tool for 
                healthcare organizations and providers to connect with their audiences,give 
                valuable information,and foster meaningful relationships with patients 
                and community at large
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph Content
        Text(
            text = """
               From promoting healthy lifestyles to raising awareness about important health topics,
               get ready to harness the power of mobile application marketing to make a positive 
               impact in the realm of healthcare.
                
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph Content
        Text(
            text = """
                To better serve the wide-ranging needs of the community, 
                hospitals has often developed outpatient facilities, 
                as well as emergency, psychiatric, and rehabilitation services.
                In addition, 'Bedless hospitals' provide strictly ambulatory (outpatient) care
                and day surgery. Patients arrive at the facility for short appointments. 
                They may also stay for treatment in surgical or medical units for part of a day. 
                or for a full day, after which they are discharged for follow-up by 
                a primary care provider.
                This CARE MOBILE APPLICATION has make the interaction 
                 of patient to doctors more uncomplicated and has aided the plainness 
                  of healthcare by patients and the community at large.   
               
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // You can continue with more content or sections as needed

    }
}

@Composable
fun ServicesContent(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        // Back Button (back navigation)
        BackButton(onBack = onBack)

        // Horizontal scrolling for images or content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()) // Horizontal scrolling
        ) {
            Image(
                painter = painterResource(id = R.drawable.ourservice),
                contentDescription = "Services Image",
                modifier = Modifier
                    .width(300.dp) // Set a fixed width for horizontal scroll
                    .height(200.dp)  // Set a fixed height
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        // Spacer to create space between content sections
        Spacer(modifier = Modifier.height(16.dp))

        // Title Text for the services section
        Text("Our Services", style = MaterialTheme.typography.headlineMedium)

        // Spacer for spacing between title and content
        Spacer(modifier = Modifier.height(16.dp))

        // Description Text - introducing the services in point form
        Text("Explore the various medical services we offer:", style = MaterialTheme.typography.bodyMedium)

        // Spacer for some space before the list
        Spacer(modifier = Modifier.height(8.dp))

        // Point form text for services offered
        ServiceList()
    }
}
@Composable
fun ServiceList() {
    Column(
        modifier = Modifier.fillMaxWidth().padding(16.dp) // Optional padding for better spacing
    ) {
        // Service 1
        Text(
            text = "INPATIENT CARE: We offer treatment or services that require you to stay in the hospital overnight, such as childbirth, major surgery, or rehabilitative treatment.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 2
        Text(
            text = "RADIOLOGY SERVICES: A multi-disciplinary specialty that is a core part of patient care in hospitals and communities. It encompasses two areas—diagnostic and interventional radiology—that both use radiant energy to diagnose and treat diseases. Common imaging exams include X-ray, ultrasound, CT scan, and PET scan.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 3
        Text(
            text = "PHARMACIST: We provide advice on how to safely use prescribed medications and deliver them to patients.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 4
        Text(
            text = "PALLIATIVE CARE: A specialized form of medical care that focuses on managing symptoms and providing pain relief for patients with serious or terminal illnesses.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 5
        Text(
            text = "PRIMARY CARE: A popular type of clinic that offers a wide range of routine and preventive health care services.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 6
        Text(
            text = "HOME CARE: A service that provides medical services similar to a hospital, but in the comfort of a patient's home.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 7
        Text(
            text = "URGENT CARE: A facility for health care needs that are not severe enough for the emergency room, but are too severe to wait for a doctor's appointment.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 8
        Text(
            text = "DIAGNOSTIC TESTING: Medical procedures or tests that help identify a disease or condition based on a person's signs and symptoms. They include laboratory tests, imaging tests (X-ray, CT scan), endoscopies (e.g., colonoscopy, bronchoscopy), and biopsy.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 9
        Text(
            text = "EMERGENCY SERVICES: We ensure public safety, security, and health by addressing and resolving different emergencies. We provide urgent treatment and stabilization for serious injuries and illnesses, and transport patients to definitive care.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 10
        Text(
            text = "SURGICAL SERVICES: A range of procedures and care that treat injuries, diseases, and deformities through surgery.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 11
        Text(
            text = "PEDIATRIC CARE: The specialty of medical science concerned with the physical, mental, and social health of children from birth to young adulthood. It encompasses a broad spectrum of health services, including preventive health care and the diagnosis and treatment of acute and chronic diseases.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 12
        Text(
            text = "NUTRITION SERVICES: The nutrition department at our hospital consists of a dedicated team of nutritionists who provide counseling and nutritional interventions essential to our health and well-being.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 13
        Text(
            text = "OTORHINOLARYNGOLOGY: Problems related to the ear, nose, and throat require a high level of precision in surgical care.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 14
        Text(
            text = "OBSTETRICS AND GYNAECOLOGY: Our hospital has highly qualified and talented specialists, supported by a team of dedicated O&G nurses and midwives, to provide comprehensive care in obstetrics and gynecology.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Service 15
        Text(
            text = "PSYCHIATRIC SERVICES: We offer a wide range of treatments to address mental health problems, emotional challenges, and psychiatric disorders. Our services include psychological assessments and interventions for various health and mental health issues.",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        // Add more services as needed
    }
}

@Composable
fun ServicePoint(service: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Bullet point (a simple circle as a bullet)
        Box(
            modifier = Modifier
                .size(12.dp)
                .background(Color.Black, shape = CircleShape)
        )

        // Spacer to create space between the bullet and text
        Spacer(modifier = Modifier.width(8.dp))

        // Text for the service
        Text(
            text = service,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@Composable
fun DiseasesContent(onBack: () -> Unit) {
    val diseases = listOf(
        Disease("Common Cold", "The common cold is an infection of your nose," +
                " sinuses, throat and windpipe. " +
                "Colds spread easily, especially within homes, classrooms and workplaces. " +
                "More than 200 different viruses can cause colds. There’s no cure for a " +
                "common cold, but it usually goes away within a week to 10 days. If you don’t feel " +
                "better in 10 days, see a healthcare provider." +
                "We call colds “common” because as their name implies," +
                " they’re widespread. You’ll probably have more colds in your lifetime than " +
                "any other illness. Adults catch two to three colds a year, while young children " +
                "come down with a cold four or more times a year." +
                "Symptoms and Causes" +
                "What are the symptoms of the common cold?\n" +
                "Common cold symptoms typically appear in stages. " +
                "The common cold stages include early, active and late.\n" +
                "\n" +
                "Stage 1: Early (Days 1 to 3)\n" +
                "Within one to three days of picking up a cold virus, " +
                "you may notice a tickle in your throat. " +
                "About half of all people with colds report a tickly or sore throat" +
                " as their first symptom. Other common cold symptoms " +
                "you may experience during this early stage include:\n" +

                "can also cause colds. More than 200 different viruses can cause a cold."),


        Disease("Disease 6", "Description of Disease 4. This disease affects the body in multiple ways..."),
        Disease("Disease 7", "Description of Disease 4. This disease affects the body in multiple ways..."),
        Disease("Disease 8", "Description of Disease 4. This disease affects the body in multiple ways..."),
        // Add more diseases as necessary
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        BackButton(onBack = onBack)

        Image(
            painter = painterResource(id = R.drawable.disease_image),
            contentDescription = "Diseases Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Heading
        Text("Diseases Information", style = MaterialTheme.typography.headlineLarge)

        Spacer(modifier = Modifier.height(16.dp))

        // Paragraph content with line breaks for better readability
        Text(
            text = "The International Classification of Diseases(ICD) is the worldwide standard" +
                    "for disease classification in public health.The ICD is used to code causes" +
                    "of death(mortality)and diseases and medical conditions(morbidity). " +
                    "The World Health Organization(WHO) is responsible for the ICD,which is" +
                    "regularly updated.",
            style = MaterialTheme.typography.bodyMedium
        )
        // Paragraph Content
        Text(
            text = """
                Classification of diseases become extremely important in the compilation of 
                statistics on causes of illness and causes of death.It is obviously important 
                to know what kind of illness and disease are prevalent in an area and how this 
                prevalence rates vary with time.
                Classifying diseases made it apparent,for example,that the frequency of lung cancer
                was entering a period of alarming increase in the mid-20th century.Once a rare 
                form of cancer,it had become the single most important form of cancer in males.
                With this knowledge a search was instituted for possible causes of this increased 
                prevalence.It was concluded that the occurrence of lung cancer was closely 
                associated with cigarette smoking.
                Classification of disease had helped to ferret out important,frequently causal,
                relationship.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph content with line breaks for better readability
        Text(
            text = "Other classification of Diseases,Clinical Modification(ICD-CM): " +
                    "A standardized system for coding diseases and medical conditions. " +

                    "International Classification of Functioning,Disability,and Health(ICF)" +
                    "A standardized system for providing information on how disability, " +
                    "health,and environment affect a person's ability to function",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))
// Paragraph Content
        Text(
            text = """
                The most widely used classifications of disease are
                (1)Topographic,by bodily region or system.
                (2)Anatomic,by organ or tissue.
                (3)Physiological,by function or effect.
                (4)Pathological,by the nature of the disease process.
                (5)Etiologic(causal).
                (6)Juristic,by speed of advent of death.
                (7)Epidemiological,
                (8)Statistical.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph Content
        Text(
            text = """
                In the topographic classification,diseases are subdivided into such categories
                as (a)gastrointestinal disease,(b)vascular disease,(c)abdominal disease,(d)chest
                disease.Various specializations within medicine follow such topographic or systemic
                divisions,so that there are physicians who are specialized in gastrointestinal
                disease.Similarly, some physicians have become specialized in chest disease and
                 concentrate principally on diseases of the heart and lungs.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        // Paragraph Content
        Text(
            text = """
                In the anatomic classification, disease is categorized by the specific organ or 
                tissue affected; hence, heart disease, liver disease, and lung disease. Medical 
                specialties such as cardiology are restricted to diseases of a single organ, 
                in this case the heart. Such a classification has its greatest use in identifying
                 the various kinds of disease that affect a particular organ. The heart is a 
                 good example to consider. By the segregation of cardiac disease it has been made 
                 apparent that heart disease is now the most important cause of death in the United 
                 States and in most other industrialized nations. Moreover, it has become apparent 
                 that disease caused by atherosclerosis of the coronary arteries is by far the most 
                 important form of heart disease. In making a diagnosis of cardiac disease in an 
                 elderly patient, the cardiologist must first determine whether this disease of the
                  coronary arteries is responsible for the heart’s failure to function normally.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )


        // Disease Classification Section
        Text("Disease Classification", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Display each disease and its explanation in paragraphs
        diseases.forEach { disease ->
            Text(
                text = disease.name,
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = disease.description,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

data class Disease(val name: String, val description: String)

@Composable
fun LearningContent(onBack: () -> Unit) {
    // Create a vertical scrollable container for the entire content
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        // Back Button (back navigation)
        BackButton(onBack = onBack)

        // Image Section with Horizontal Scrolling
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())  // Horizontal scrolling
        ) {
            // Display Image with fixed size (or you can adjust based on content)
            Image(
                painter = painterResource(id = R.drawable.learning_image),
                contentDescription = "Learning Image",
                modifier = Modifier
                    .height(300.dp)  // Fixed height for image (adjust as needed)
                    .width(300.dp)   // Width that allows horizontal scroll
                    .clip(RoundedCornerShape(8.dp)),  // Optional rounded corners
                contentScale = ContentScale.Crop  // Image scaling for cropping
            )
        }

        // Spacer to add vertical space between the image and text content
        Spacer(modifier = Modifier.height(16.dp))

        // Title Text for the Learning Content Section
        Text(
            text = "Learning Content",
            style = MaterialTheme.typography.headlineMedium
        )

        // Spacer for spacing between title and body text
        Spacer(modifier = Modifier.height(16.dp))

        // Descriptive Text for learning content in paragraph form
        Text(
            text = """
                Access a wide range of educational resources related to health, diseases, and treatments. 
                Our materials cover a variety of topics, including the causes, symptoms, and prevention 
                strategies for common diseases such as infectious diseases, chronic conditions, and mental 
                health disorders. Learn about the methods of disease spread, the role of vaccinations, 
                the importance of hygiene, and lifestyle changes to prevent illness. We aim to provide 
                evidence-based information to help you make informed decisions regarding your health and 
                well-being. Whether you're a student, a health professional, or simply looking to expand 
                your knowledge, our resources offer practical advice and expert insights on a wide range 
                of health topics.
                Communicable Diseases.
                A communicable disease is one that spreads from one person or animal to
                 another or from a surface to a person. They are the result of pathogens, 
                 such as viruses and bacteria. Communicable diseases include colds and flu.
                 Communicable diseases can transmit through contact with bodily fluids, 
                 insect bites, contaminated surfaces, water, and foods, or through the air.
                 A communicable disease is any disease that passes between people or animals. People sometimes refer to communicable diseases as “infectious” or “transmissible” diseases.

                 Pathogens, including bacteria, viruses, fungi, and protozoa, 
                 cause communicable diseases.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = """
               Symptoms
               Once a pathogen has entered a person’s body, it often will begin replicating.
                The individual may then begin to experience symptoms.

               Symptoms will vary depending on the disease. Some people will not
                experience any symptoms. However, they can still transmit the pathogen.

               Some symptoms are a direct result of the pathogen damaging the body’s cells. 
               Others are due to the body’s immune response to the infection.

               Some communicable diseases may be mild, and symptoms pass after a few days. 
               However, some can be serious and potentially life threatening. 
               Symptom severity may vary depending on a person’s overall health and immune function.

               Types and symptoms
               Four main types of pathogens cause infection: Viruses, bacteria, fungi, and protozoa.

               Viruses
               Viruses are tiny pathogens that contain genetic material. Unlike other pathogens, 
               they lack the complex structure of a cell.

               To replicate, they must enter the cells of other living beings. Once inside, 
               they use the cell’s machinery to make copies of themselves.

               Bacteria
               Bacteria are microscopic, single-celled organisms. They exist in almost
                every environment on earth, including inside the human body.

            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = """
           Causes
           A person may develop a communicable disease after becoming infected by the pathogen. 
           This may happen through:

           direct contact with a person carrying the pathogen
           contact with bodily fluids containing pathogens
           inhaling pathogen-containing droplets from another person’s cough or sneeze
           receiving a bite from an animal or insect carrying the pathogen
           consuming contaminated water or foods
           How to prevent transmission
           People can reduce their risk of contracting or transmitting disease-causing
            pathogens by following the steps below:

           washing their hands thoroughly and regularly
           disinfecting surfaces at home often, especially doorknobs and food areas
           disinfecting personal items such as phones
           cooking meats, eggs, and other foods thoroughly
           practicing good hygiene when preparing and handling food
           avoiding eating spoiled food
           avoiding touching wild animals
           receiving available vaccinations
           taking antimalarial medications when traveling where there is a malaria risk
           check for ticks and other parasites
           Treatment for communicable diseases
           Some communicable diseases cause only mild symptoms that disappear 
           without treatment. Others may cause severe symptoms or potentially life threatening complications.



            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = """
         What to know about Airborne Diseases.
         Airborne diseases pass from one person to another when microorganisms 
         travel through the air. Chickenpox, the common cold,
          and COVID-19 are examples of airborne diseases.
          Airborne diseases can transmitTrusted Source through coughs or sneezes, 
          spraying liquid, or dust. The microorganisms may come from a person or animal 
          who has a disease or from soil, garbage, or other sources.

          Depending on the pathogens, factors that affect how long they remain active include:

          air temperature
          humidity
          exposure to sunlight or other forms of radiation
          the weight of the particles, which can affect how long they take to settle
          the structure and stability of the pathogen
          It is not always possible to prevent the spread of airborne diseases, 
          but individuals and authorities can take measures to reduce the risk by
           recommending or ensuring adequate ventilation and the use of protective equipment.
            """.trimIndent(),
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Spacer for spacing
        Spacer(modifier = Modifier.height(16.dp))

        // Additional content can go here, if needed
    }
}

@Composable
fun VideoPlayer(videoUrl: String) {
    TODO("Not yet implemented")
}


// Doctors Directory with vertical and horizontal scrolling
@Composable
fun DoctorsDirectoryContent(onBack: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }

    val context = LocalContext.current // Get context directly here

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)
        .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        BackButton(onBack = onBack)

        // Horizontal scrolling for the doctor's image or other content
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState()) // Horizontal scrolling
        ) {
            Image(
                painter = painterResource(id = R.drawable.doctors_directory),
                contentDescription = "Doctors Directory Image",
                modifier = Modifier
                    .width(300.dp)
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Book an Appointment", style = MaterialTheme.typography.headlineMedium)


        // Name Input
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Age Input
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Location Input
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        // Sex Input
        OutlinedTextField(
            value = sex,
            onValueChange = { sex = it },
            label = { Text("Sex (M/F)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Phone Number Input
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        // Email Input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )
// Date Input
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )
        // Submit Button
        Button(
            onClick = {
                // Handle form submission
                Toast.makeText(context, "Appointment booked successfully", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Book Appointment")
        }
    }
}
@Composable
fun HealthRecordsContent(onBack: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var sex by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var doctorDescription by remember { mutableStateOf("") } // This will be filled by the user
    var idNumber by remember { mutableStateOf("") } // Added state for ID number

    // State to hold the saved health record
    var savedRecord by remember { mutableStateOf<HealthRecord?>(null) }
    val context = LocalContext.current // Access context outside the lambda

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        // Back Button
        BackButton(onBack = onBack)

        // Image for the health records section (Horizontal scrollable)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())  // Horizontal scrolling
        ) {
            Image(
                painter = painterResource(id = R.drawable.health_record_image),
                contentDescription = "Health Records Image",
                modifier = Modifier
                    .width(300.dp)  // Set fixed width for horizontal scroll
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title Text
        Text("Health Records", style = MaterialTheme.typography.headlineMedium)

        // Spacer for vertical spacing
        Spacer(modifier = Modifier.height(16.dp))

        // Name Input
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        // Age Input
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Age") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Location Input
        OutlinedTextField(
            value = location,
            onValueChange = { location = it },
            label = { Text("Location") },
            modifier = Modifier.fillMaxWidth()
        )

        // Sex Input
        OutlinedTextField(
            value = sex,
            onValueChange = { sex = it },
            label = { Text("Sex (M/F)") },
            modifier = Modifier.fillMaxWidth()
        )

        // Phone Number Input
        OutlinedTextField(
            value = phone,
            onValueChange = { phone = it },
            label = { Text("Phone Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone),
            modifier = Modifier.fillMaxWidth()
        )

        // Email Input
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth()
        )

        // Date Input
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date") },
            modifier = Modifier.fillMaxWidth()
        )
        // Identification Number Input (New Field)
        OutlinedTextField(
            value = idNumber,
            onValueChange = { idNumber = it },
            label = { Text("Identification Number") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        // Doctor's Description Input
        OutlinedTextField(
            value = doctorDescription,
            onValueChange = { doctorDescription = it },
            label = { Text("Doctor's Description") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = 3
        )

        // Save Health Record Button
        Button(
            onClick = {
                // Save the health record (in this case, in memory)
                savedRecord = HealthRecord(name, age, location, sex, phone, email, doctorDescription, date, idNumber)

                Toast.makeText(
                    context,
                    "Health Record saved successfully",
                    Toast.LENGTH_SHORT
                ).show()
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Save Health Record")
        }
    }
}

// A simple data class for holding health record data with the added ID field
data class HealthRecord(
    val name: String,
    val age: String,
    val location: String,
    val sex: String,
    val phone: String,
    val email: String,
    val doctorDescription: String,  // This is the doctor's input
    val date: String,
    val idNumber: String // Added ID number to the data class
)

// Contact Us Screen with vertical and horizontal scrolling
@Composable
fun ContactUsContent(onBack: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())  // Vertical scrolling
    ) {
        // Back Button (back navigation)
        BackButton(onBack = onBack)

        // Horizontal scrolling for images or content (optional)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())  // Horizontal scrolling
        ) {
            Image(
                painter = painterResource(id = R.drawable.contact_us_image),
                contentDescription = "Contact Us Image",
                modifier = Modifier
                    .width(300.dp)  // Fixed width for horizontal scroll
                    .height(200.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Title Text for Contact Us section
        Text("Contact Us", style = MaterialTheme.typography.headlineMedium)

        // Spacer for vertical space
        Spacer(modifier = Modifier.height(16.dp))

        // General Contact Information
        Text(
            text = "For inquiries, please reach out to us via:",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Email and Phone contact details
        ContactInfoRow(
            label = "Email:",
            value = "care@app.gmail.com",
            icon = Icons.Default.Menu
        )
        ContactInfoRow(
            label = "Phone:",
            value = "0987-654-321",
            icon = Icons.Default.Menu
        )

        ContactInfoRow(
            label = "Phone 2:",
            value = "123-456-7890",
            icon = Icons.Default.Menu
        )
        ContactInfoRow(
            label = "P.O BOX:",
            value = "342-01000 Thika",
            icon = Icons.Default.Menu
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Emergency Contacts Section
        Text(
            text = "Emergency Contacts:",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        EmergencyContactInfoRow(
            label = "Emergency Hotline 1:",
            value = "911",
            icon = Icons.Default.Warning
        )

        EmergencyContactInfoRow(
            label = "Emergency Hotline 2:",
            value = "123-987-6543",
            icon = Icons.Default.Warning
        )

        Spacer(modifier = Modifier.height(16.dp))


        }
    }


@Composable
fun ContactInfoRow(label: String, value: String, icon: ImageVector) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp),
            tint = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "$label $value",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun EmergencyContactInfoRow(label: String, value: String, icon: ImageVector) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.padding(end = 8.dp),
            tint = Color.Red  // Emergency contacts may have red icons for urgency
        )
        Text(
            text = "$label $value",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Red,  // Red text for emergency contacts
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun MenuButton(text: String, icon: ImageVector, isSelected: Boolean, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
        )
    ) {
        Icon(imageVector = icon, contentDescription = text)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text)
    }
}
