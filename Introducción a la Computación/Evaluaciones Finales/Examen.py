#Definición de Variables de entrada
print("------------------------------------------")
primerNumero = input("Inserte un número binario: ")
segundoNumero = input("Inserte un segundo número binario: ")
print("------------------------------------------")

#Longitud de entradas
cantidadprimero = len(primerNumero)
cantidadsegundo = len(segundoNumero)

#Distribución de dígitos
#Primer Número
unosPrimero = 0
cerosPrimero = 0
diferentesPrimero = 0
#Segundo Número
unosSegundo = 0
cerosSegundo = 0
diferentesSegundo = 0

validacion = True

#Verificaciones
#Longitud de ambas entradas
if cantidadsegundo == cantidadprimero:
  print(f"Ambas colecciones tienen {cantidadprimero} caracteres")
else:
  print("La longitud de los números no es la misma")
  validacion = False

#Cantidad de 1's y 0's en Primer Numero
for i in primerNumero:
  if i == "1":
    unosPrimero += 1
  elif i == "0":
    cerosPrimero += 1
  else:
    diferentesPrimero += 1

#Cantidad de 1's y 0's en Segundo Numero
for i in segundoNumero:
  if i == "1":
    unosSegundo += 1
  elif i == "0":
    cerosSegundo += 1
  else:
    diferentesSegundo += 1

#Impresión de propiedades de Contenido
#Primero
if diferentesPrimero == 0:
  print(f"La hilera {primerNumero} no tiene numeros diferentes a 1 y 0")
else:
  #Bit y Bits
  validacion = False
  if diferentesPrimero == 1:
    print(f"La hilera {primerNumero} tiene {diferentesPrimero} bit diferente a 1 y 0")
  else:
    print(f"La hilera {primerNumero} tiene {diferentesPrimero} bits diferentes a 1 y 0")

#Segundo
if diferentesSegundo == 0:
  print(f"La hilera {segundoNumero} no tiene numeros diferentes a 1 y 0")
else:
  #Bit y Bits
  validacion = False
  if diferentesPrimero == 1:
    print(f"La hilera {segundoNumero} tiene {diferentesSegundo} bit diferente a 1 y 0")
  else:
    print(f"La hilera {segundoNumero} tiene {diferentesSegundo} bits diferentes a 1 y 0")

#Igualdad entre hileras
numerosdiferentes = 0
#Ciclo
if primerNumero == segundoNumero:
  validacion = False
  print(primerNumero, "es igual a ", segundoNumero)
else:
  for i,x in zip(primerNumero, segundoNumero):
    if x != i:
      numerosdiferentes += 1
  #Bits o Bit
  if numerosdiferentes == 1:
    print("Las colecciones no son iguales, tienen",numerosdiferentes,"bit diferente\n")
  else:
    print("Las colecciones no son iguales, tienen",numerosdiferentes,"bits diferentes\n")

#Cantidad de 1´s y 0´s
while validacion:
  print(f"La hilera {primerNumero} tiene: {unosPrimero} 1's y {cerosPrimero} 0's")
  print(f"La hilera {segundoNumero} tiene: {unosSegundo} 1's y {cerosSegundo} 0's")
  
  #Valores en Decimal
  print("\n")
  decimalPrimero = 0
  potenciaPrimero = cantidadprimero - 1
  for bit in primerNumero:
    decimalPrimero += int(bit) * (2 ** potenciaPrimero)
    potenciaPrimero -= 1
  print(f"El número {primerNumero} en decimal es: {decimalPrimero}")
  
  decimalSegundo = 0
  potenciaSegundo = cantidadsegundo - 1
  for bit in segundoNumero:
    decimalSegundo += int(bit) * (2 ** potenciaSegundo)
    potenciaSegundo -= 1
  print(f"El número {segundoNumero} en decimal es: {decimalSegundo}")
  validacion = False