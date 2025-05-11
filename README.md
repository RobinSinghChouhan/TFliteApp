# 📱 TFLite Text Classifier Android App

This Android app uses a pre-trained TensorFlow Lite model to classify social media text posts into one of 10 categories, such as `technology`, `sports`, `finance`, etc. The app is built using Kotlin and Jetpack Compose and performs **on-device inference** using a `.tflite` model.

---

## 🚀 Features

- ✅ Offline text classification using TFLite
- ✅ Jetpack Compose UI with multiline text area
- ✅ Top category prediction with confidence
- ✅ Supports 11 custom categories
- ✅ Fast and efficient on-device inference

---

## 🧠 Model Info

- Model: `model_with_softmax.tflite`
- Input: Sequence of token IDs (`int32[1, 50]`)
- Output: Probability vector (`float32[1, 10]`)
- Preprocessing: Manual tokenization using `vocab.txt`


