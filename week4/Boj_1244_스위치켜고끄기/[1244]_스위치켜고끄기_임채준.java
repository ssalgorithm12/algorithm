����   = m  +boj/Boj_1244스위치켜고끄기_임채준  java/lang/Object num I status [I <init> ()V Code
   	 
 LineNumberTable LocalVariableTable this -Lboj/Boj_1244스위치켜고끄기_임채준; main ([Ljava/lang/String;)V 
Exceptions  java/lang/Exception  java/io/BufferedReader  java/io/InputStreamReader	    java/lang/System    in Ljava/io/InputStream;
  " 	 # (Ljava/io/InputStream;)V
  % 	 & (Ljava/io/Reader;)V
  ( ) * readLine ()Ljava/lang/String;
 , . - java/lang/Integer / 0 parseInt (Ljava/lang/String;)I	  2   4 java/util/StringTokenizer
 3 6 	 7 (Ljava/lang/String;)V	  9  
 3 ; < * 	nextToken > java/lang/StringBuilder
 = 
 = A B C append (I)Ljava/lang/StringBuilder; E  
 = G B H -(Ljava/lang/String;)Ljava/lang/StringBuilder; J 
	  L M N out Ljava/io/PrintStream;
 = P Q * toString
 S U T java/lang/String V * trim
 X Z Y java/io/PrintStream [ 7 println args [Ljava/lang/String; br Ljava/io/BufferedReader; st Ljava/util/StringTokenizer; i len gen idx j sb Ljava/lang/StringBuilder; StackMapTable ] 
SourceFile ,Boj_1244스위치켜고끄기_임채준.java !                  	 
     /     *� �                        	            �    f� Y� Y� � !� $L+� '� +� 1� 3Y+� '� 5M� 1`�
� 8>� � 8,� :� +O�� 1���+� '� +>6� �� 3Y+� '� 5M,� :� +6,� :� +6� *6� � 8� 8.dO`6� 1��� p� j� 8� 8.dO6� C� 8d.� 8`.� A� 8d� 8d.dO� 8`� 8`.dO�d� `� 1������B� =Y� ?:6� '� 8.� @D� FWp� I� FW�� 1��ײ K� O� R� W�       � !        (  2  7  C  M  U  [  g  p  y    �  �  �  �  �   � ! � " � # � $ � (  !  ,% -+ .< /L -W 1e 2    z   f \ ]   T ^ _  (> ` a  4  b   U c   X � b   p � d   y � e   �   f   � V f  % A g h ( / b   i   ; � 7  3� � *� 
� ?� �   j  3 =     k    l