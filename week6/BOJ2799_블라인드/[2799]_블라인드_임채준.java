����   = �  "boj/Boj_2799블라인드_임채준  java/lang/Object window [[C ans [I N I M <init> ()V Code
     LineNumberTable LocalVariableTable this $Lboj/Boj_2799블라인드_임채준; main ([Ljava/lang/String;)V 
Exceptions  java/lang/Exception  java/io/BufferedReader  java/io/InputStreamReader	  !   java/lang/System " # in Ljava/io/InputStream;
  %  & (Ljava/io/InputStream;)V
  (  ) (Ljava/io/Reader;)V + java/util/StringTokenizer
  - . / readLine ()Ljava/lang/String;
 * 1  2 (Ljava/lang/String;)V
 * 4 5 / 	nextToken
 7 9 8 java/lang/Integer : ; parseInt (Ljava/lang/String;)I	  = 	 
	  ?  
 	  B  	  D  
 F H G java/lang/String I J toCharArray ()[C L java/lang/StringBuilder
 K    O P Q makeConcatWithConstants (I)Ljava/lang/String;
 K S T U append -(Ljava/lang/String;)Ljava/lang/StringBuilder;	  W X Y out Ljava/io/PrintStream;
 K [ \ / toString
 ^ ` _ java/io/PrintStream a 2 println args [Ljava/lang/String; br Ljava/io/BufferedReader; st Ljava/util/StringTokenizer; i r c sb Ljava/lang/StringBuilder; StackMapTable c 
SourceFile #Boj_2799블라인드_임채준.java BootstrapMethods
 s u t $java/lang/invoke/StringConcatFactory P v �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite; r y   InnerClasses | %java/lang/invoke/MethodHandles$Lookup ~ java/lang/invoke/MethodHandles Lookup !                 	 
     
           /     *� �                        	            �    �� Y� Y� � $� 'L� *Y+� ,� 0M,� 3� 6� <,� 3� 6� >� <h`� >h`� @� A�
� C>� � A+� ,� ES�� <h`���>� �6� � Ah`2h`4.� � C\.`O� ò Ah`2h`4*� $� Ah`2h`4.� � C\.`O� �� Ah`2h`4*� $� Ah`2h`4.� � C\.`O� W� Ah`2h`4*� $� Ah`2h`4.� � C\.`O� !� Ah`2h`4*� � C\.`O�� >���� <��� KY� MN6� -� C.� N  � RW���� V-� Z� ]�       v         (  2  G  M  R  ^  l  q  w  �  �  �   � ! � " #. $7 %O &X c m +u ,{ -� ,� /� 4    R   � b c   � d e  � f g  O  h 
  n � i 
  t � j 
 u * k l x  h 
  m   0 � R  *�  555� 
�   n  * K    o    p q     w  x z   
  { }  