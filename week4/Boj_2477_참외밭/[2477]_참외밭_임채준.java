����   = ^  boj/Boj_2477참외밭_임채준  java/lang/Object nperm I map [[I count [I big small <init> ()V Code
     LineNumberTable LocalVariableTable this !Lboj/Boj_2477참외밭_임채준; main ([Ljava/lang/String;)V 
Exceptions  java/lang/Exception  java/io/BufferedReader  java/io/InputStreamReader	   " ! java/lang/System # $ in Ljava/io/InputStream;
  &  ' (Ljava/io/InputStream;)V
  )  * (Ljava/io/Reader;)V
  , - . readLine ()Ljava/lang/String;
 0 2 1 java/lang/Integer 3 4 parseInt (Ljava/lang/String;)I	  6   	  9   ; java/util/StringTokenizer
 : =  > (Ljava/lang/String;)V
 : @ A . 	nextToken	  C 	 
	  E  	  G  	   I J K out Ljava/io/PrintStream;
 M O N java/io/PrintStream P Q println (I)V args [Ljava/lang/String; br Ljava/io/BufferedReader; i st Ljava/util/StringTokenizer; j answer StackMapTable 
SourceFile  Boj_2477참외밭_임채준.java !                 	 
                     /     *� �                        	                � Y� Y� � %� (L+� +� /� 5� 7� 8=� 0� :Y+� +� <N6� � 82-� ?� /O��������
� B=� � B� 82.\.`O����� D� F=�K� B� 82..� F� B� 8`2..� 5� 0� 82.� 8`2.h� D� 8`2.� 8`2.h� F� �� B� 82..� F� B� 8`2..� 5� 0� 82.� 8`2.h� D� 8d2.� 8d2.h� F� �� B� 82..� C� B� 82..� 4� 0� 82.� 8`2.h� D� 8`2.� 8`2.h� F� ]� B� 82..� F� B� 8`2..� 5� 0� 82.� 8`2.h� D� 8d2.� 8`2.h� F� ����� 5� D� Fdh=� H� L�       � $        &  +  7  =  L  U  ^  d  i  x  �   � ! � " � # � % � & � ' � ( * +/ ,2 -T /h 0~ 1� 2� 4� 5� 6� "� :� ;� <    R   � R S   � T U  ( 6 V   7  W X  :  Y   f  V   �P V  �  Z   [   ' � + �  :� � Q� Q� N� Q�   \    ]