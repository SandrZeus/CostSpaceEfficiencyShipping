# CostSpaceEfficiencyShipping
Java app for shipping different products with the best possible way using two different sized and priced containers.

Hi, I'm Sandro and this was my university assignment.

Project Description:
Your  work  is  to  design  and  implement  an  application  using  Java,  to be  used  to  calculate  the  shipping  cost  of  the  productsfrom  China  to Germany in regular bases, You have several products to be shipped: 1-Laptop which has a box size: 60x50x50 cm and weight of 6.5 kg. 2-Mouse which has a box size: 30x30x20 cm and weight of 200 g. 3-Desktop which has a box size:100x150x50 cm and weight of 20 kg. 4-LCD screens which has a box size 120x140x 80 cm and weight of 2.6kg. You have at the same time 2 different shipping options: 1-Small Container with 2.59m height, 2.43m wide, and 6.06m length. 2-Big Container with 2.59m height, 2.43m wide, and 12.01m length. The shipping cost for big container is 1800 Euro whatever the shipment weight is. The shipping cost for small container 1000 Euro for 500 kg or less, and 1200 Euro for weight morethan 500kg. Write  a  program  that  calculate  the best  shippingmethods  according  to your regular shipping products (Whatever number of the products that you have).The  program  must  read  from  user  the  order  information  for  example: 100Lap, 200 Mouse, 150 Desktop, 200 LCD screen, then calculate the best shipping methods according to less price, for example (1 big container, or 2 big  containers,  or  1  big  container  and  1  small  container,  According  to maximum volume of the shipment and the total shipment weight).(PS:the shipment will have to be fit exactlyto the containers). 2.Solution Steps: Please follows the following stepsduring the solution: A. In Package itemscreate a class Itemthat has: Constructors. Getter and setters. Calculate Volume Method. Print item info. In the containerspackage create Containermethodthat has Constructors. Getter and Setters. Calculate Volume. Print container info. In the methodspackage create method Calculationthat used to perform all the needed calculations, which has at least the following methods: The totalVolumemethod, The totalWeightmethod, The bestShipping method, The hippingPrice method, The addItems method, The addOrder method, The printItem method to print items information’s, The printOrder method to show orderinformation’s and price. Create Test main static methods to Add products details Read the order. Print the results.
