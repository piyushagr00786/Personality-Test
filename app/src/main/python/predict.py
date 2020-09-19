from tensorflow.keras.models import load_model
import pickle
import tensorflow as tf
from tensorflow.keras.preprocessing import sequence
import numpy as np
from os.path import dirname, join
stopword=['d', 'we', "shouldn't", 'of', 'same', 'themselves', 'an', 'mustn', 'above', 'here', 'hadn', 'me', 'when', "you'll", "hadn't", 'few', 'there', "weren't", 'but', 'he', 'other', 'until', 's', 'which', 'as', 'were', 'such', "wasn't", 'it', 'doing', 'does', 'your', 'ain', 'should', 'by', 'no', 'hasn', 'at', 'isn', 'yourselves', 'only', 'or', 'down', 'more', 'myself', "needn't", 'been', 'off', "you'd", 'and', 'them', 'once', 'shouldn', 'having', 'where', 'below', 'before', 'o', "shan't", 'll', 'be', 'do', 'between', 'both', 'too', 'is', 'how', 'those', 'wasn', 'm', "aren't", 'herself', 'most', 'yourself', 'had', "mightn't", "you're", "didn't", 'all', 'our', 'now', 'into', "mustn't", 'against', "isn't", 'the', 'whom', 'a', "couldn't", 'if', 'during', 'than', 'not', 'in', 't', 'ourselves', 'for', 'i', 'have', 'own', 'through', 'haven', 'because', "you've", 'this', 'these', "hasn't", 're', "won't", 'his', 'why', "that'll", 'hers', 'didn', 'just', 'who', 'was', 'then', 'itself', "it's", 'some', 'can', "doesn't", 've', 'doesn', 'she', 'my', 'theirs', 'what', 'after', 'each', 'under', "haven't", 'won', 'again', 'has', 'its', 'being', 'weren', 'are', 'with', 'mightn', 'don', 'needn', 'you', 'that', "she's", 'from', 'so', 'did', 'out', 'shan', 'on', 'him', 'couldn', 'their', 'they', 'further', 'to', 'about', 'while', 'up', 'himself', "wouldn't", 'aren', 'am', 'over', 'wouldn', 'ma', 'any', 'y', 'ours', 'yours', "don't", 'nor', 'will', "should've", 'her']
import re


# Function to clean data ... will be useful later
def post_cleaner(post):
    """cleans individual posts`.
    Args:
        post-string
    Returns:
         cleaned up post`.
    """
    # Covert all uppercase characters to lower case
    post = post.lower() 
    
    # Remove |||
    post=post.replace('|||',"") 

    # Remove URLs, links etc
    post = re.sub(r'''(?i)\b((?:https?://|www\d{0,3}[.]|[a-z0-9.\-]+[.][a-z]{2,4}/)(?:[^\s()<>]+|\(([^\s()<>]+|(\([^\s()<>]+\)))*\))+(?:\(([^\s()<>]+|(\([^\s()<>]+\)))*\)|[^\s`!()\[\]{};:'".,<>?«»“”‘’]))''', '', post, flags=re.MULTILINE) 
    # This would have removed most of the links but probably not all 

    # Remove puntuations 
    puncs1=['@','#','$','%','^','&','*','(',')','-','_','+','=','{','}','[',']','|','\\','"',"'",';',':','<','>','/']
    for punc in puncs1:
        post=post.replace(punc,'') 

    puncs2=[',','.','?','!','\n']
    for punc in puncs2:
        post=post.replace(punc,' ') 
    # Remove extra white spaces
    post=re.sub( '\s+', ' ', post ).strip()
    
    post=' '.join(e.lower() for e in post.split() if e.lower() not in stopword)

    return post

def predict(string):
    f = open(join(dirname(__file__), 'tokenizer.pickle'),'rb' )
    tokenizer = pickle.load(f)
    f = join(dirname(__file__), 'personality_new_testing.h5')

    model1 = tf.keras.models.load_model(f)



    l=[]

    for i in string.split('+'):
        
        rev1=np.array([post_cleaner(i)])
        s=tokenizer.texts_to_sequences(rev1)
        seque = sequence.pad_sequences(s, maxlen=1000) 
        
        s=model1.predict_classes(seque)
        l.append(s[0])

    
    p=min(set(l), key = l.count)
        
    mbti_dict={0:'ENFJ',1:'ENFP',2:'ENTJ',3:'ENTP',4:'ESFJ',5:'ESFP',6:'ESTJ',7:'ESTP',8:'INFJ',9:'INFP',10:'INTJ',11:'INTP',12:'ISFJ',13:'ISFP',14:'ISFP',15:'ISTP'}
    return (mbti_dict[p])