import textract
import pandas
import cv2
import PyPDF2 
import textract
from nltk.tokenize import word_tokenize
from nltk.corpus import stopwords
print('Libraries Imported')
import pytesseract
from PIL import Image

print('success so far')


def main():
    
    # Load the required image
    #image = cv2.imread('3D_INVESTMENT PARTNERS_15887-1.jpg')
    image = cv2.imread('image1.jpg')
    gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)

    preprocess = False
    temp = input(
        "Do you want to pre-process the image ?\nThreshold : 1\nGrey : 2\nNone : 0\nEnter your choice : ").strip()

    # If user enters 1, Process Threshold. Else if user enters 2, Process Median Blur. Else, do nothing
    if temp == "1":
        gray = cv2.threshold(gray, 0, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)[1]
    elif temp == "2":
        gray = cv2.medianBlur(gray, 3)

    # Store grayscale image as a temporary file to apply OCR
    filename = "{}.png".format("temp")
    cv2.imwrite(filename, gray)

    # Load the image as a PIL/Pillow image, apply OCR, and then delete the temporary file
    text = pytesseract.image_to_string(Image.open(filename))
	
    print("OCR Text is " + text)
	
    print("\n")
    print("\n")		
    print("\n")
    i=(text.find("Customer Account No:"))	
    print(text[i:i+30])
    i=(text.find("Date:"))	
    print(text[i:i+25])
    i=(text.find("GSI Reference Number:"))
    j=(text[i:i+100].find("  "))	
    print(text[i:i+52])


try:
    main()
except Exception as e:
    print(e.args)
    print(e.__cause__)
