����   = l  boj/Boj_2564경비원_임채준  java/lang/Object hor I ver num store [[I leng [I locd loc sum <init> ()V Code
     LineNumberTable LocalVariableTable this !Lboj/Boj_2564경비원_임채준; main ([Ljava/lang/String;)V 
Exceptions  java/lang/Exception  java/io/BufferedReader ! java/io/InputStreamReader	 # % $ java/lang/System & ' in Ljava/io/InputStream;
   )  * (Ljava/io/InputStream;)V
  ,  - (Ljava/io/Reader;)V / java/util/StringTokenizer
  1 2 3 readLine ()Ljava/lang/String;
 . 5  6 (Ljava/lang/String;)V
 . 8 9 3 	nextToken
 ; = < java/lang/Integer > ? parseInt (Ljava/lang/String;)I	  A  	  C  	  E   
	  H 	 
	  J  	  L  	  N  	  P  
 R T S java/lang/Math U V abs (I)I	 # X Y Z out Ljava/io/PrintStream;
 \ ^ ] java/io/PrintStream _ ` println (I)V args [Ljava/lang/String; br Ljava/io/BufferedReader; st Ljava/util/StringTokenizer; i j StackMapTable 
SourceFile  Boj_2564경비원_임채준.java !                      	 
                               /     *� �                        	            -    �� Y�  Y� "� (� +L� .Y+� 0� 4M,� 7� :� @,� 7� :� B+� 0� :� D� D� F� G� D�
� I>� 0� .Y+� 0� 4M6� � G2,� 7� :O����� D��ϻ .Y+� 0� 4M,� 7� :� K,� 7� :� M>��� K� � G2.� +� G2.� @� Md� � I� @� Md� G2.dO� �� G2.� � I� @� Md� B`� G2.dO� �� G2.� � I� @� Md� B`� G2.`O� c� G2.�  � I� @h� Md� B`� G2.`O� ;� G2.� 0� G2.� @� Md� � I� @h� Bh`� Md� G2.dO� K� � G2.� +� G2.� @� Md� � I� @� Md� G2.dO� �� G2.� � I� @� Md� G2.`O� �� G2.� � I� @� Md� B`� G2.`O� e� G2.� "� I� @h� Bh`� Md� G2.dO� ;� G2.� 0� G2.� @� Md� � I� @h� Bh`� Md� G2.dO� K� � G2.� +� G2.� B� Md� � I� B� Md� G2.dO� �� G2.� � I� @� B`� Md� G2.dO� �� G2.� � I� @� B`� Md� G2.`O� c� G2.�  � I� @� Bh`� Md� G2.`O� ;� G2.� 0� G2.� B� Md� � I� @h� Bh`� Md� G2.dO� K� � G2.� +� G2.� B� Md� � I� B� Md� G2.dO� �� G2.� � I� B� Md� G2.`O� �� G2.� � I� B� Md� @`� G2.`O� e� G2.� "� I� Bh� Md� @h`� G2.dO� ;� G2.� 0� G2.� B� Md� � I� @h� Bh`� Md� G2.dO�� D��e� @� B`� M� O>� � O� M� I.d� Q`� O�� D��� W� O� [�       E        (  2  <  G  O   T ! ` " f # u " ~   � ' � ( � ) � , � - � . � / � 0 � 1
 2 30 4> 5X 6w 7� :� ;� <� =� >� ?� @ A  B< C[ Dw G~ H� I� J� K� L� M� N O" PA Q] Td U� V� W� X� Y� Z� [� \ ]% ^A ,K bU dY e^ fq e{ h� i    H   � a b   s c d  g e f  Q 7 g   c  h   �� g  [   g   i   , � T  .� � +9%%'79!%)79%%'79!%)7  j    k