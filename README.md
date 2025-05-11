# 📱 TFLite Text Classifier Android App

This Android app uses a TensorFlow Lite model to classify social media posts into 11 categories such as `technology`, `sports`, `finance`, and more. It is built with Kotlin and Jetpack Compose, and runs entirely on-device using TensorFlow Lite.

---

## 🚀 Features

- ✅ On-device classification using TFLite
- ✅ Built with Jetpack Compose and Kotlin
- ✅ Multi-line text input area
- ✅ Probabilities shown for each category
- ✅ Fast and lightweight model inference
- ✅ Manual tokenizer using `vocab.txt`

---

## 📓 Android.ipynb – Python Training Notebook

This project includes a companion Jupyter notebook named **`Android.ipynb`**, which contains the complete training pipeline for the text classification model. It covers:

- ✅ Loading and preparing training data
- ✅ Tokenization using `TextVectorization`
- ✅ Building and training the Keras model
- ✅ Converting the trained model to TensorFlow Lite (`.tflite`)
- ✅ Exporting `vocab.txt` and `labels.txt` for Android inference

Use this notebook to retrain or modify your model, ensuring consistency between the Python training environment and Android deployment.

---

## 🧠 Model Overview

- **Model file**: `model_with_softmax.tflite`
- **Input**: `int32[1, 50]` — tokenized & padded sequence
- **Output**: `float32[1, 10]` — probability vector (softmax)
- **Tokenizer**: Python-generated `vocab.txt` from `TextVectorization`
- **Labels**: Category list in `labels.txt`

---

## 📁 Folder Structure

```
app/
 ├── assets/
         │    ├── model_with_softmax.tflite
         │    ├── vocab.txt
         │    └── labels.txt
         └── res/
             └── layout/ (if any legacy UI)
```

---

## 🛠️ Setup Instructions

1. Add dependencies to your `build.gradle`:

```gradle
implementation 'org.tensorflow:tensorflow-lite:2.12.0'
implementation 'org.tensorflow:tensorflow-lite-support:0.3.1'
```

2. Place the following files into `app/src/main/assets/`:
    - `model_with_softmax.tflite`
    - `vocab.txt`
    - `labels.txt`

3. Load model and assets in your Kotlin code:

```kotlin
TextClassifier.initialize(context)
```

---

## 🧪 Example Usage in Jetpack Compose

```kotlin
val text by remember { mutableStateOf("") }

Column {
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text("Enter your post...") },
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp),
        maxLines = 5
    )

    Button(onClick = {
        val result = TextClassifier.predictAll(text)
        val formatted = result.joinToString("\n") { (label, prob) ->
            "$label: ${"%.2f".format(prob * 100)}%"
        }
        Log.d("Prediction", formatted)
    }) {
        Text("Classify")
    }
}
```

---

## 📌 Notes

- Your `.tflite` model **must include softmax**
- `vocab.txt` and `labels.txt` must match training
- Android must read from `assets/`, not `res/`
- Use `coerceIn()` to keep predictions in 0–1 range for display

---

## 📜 License

MIT — free to use, modify, and share.
