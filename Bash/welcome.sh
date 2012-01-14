number=$RANDOM
let "number %= 6"
data=$(date +'%d-%m')
ora=$(date +'%H')

if [ "$data" = "25-12" ]; then
	echo "Natale non e' Natale senza l'alberello sul terminale."
elif [ "$data" = "01-01" ]; then
	echo "La CPU ti fa gli auguri di buon anno, sperando che tu gli dia un pò di pace e serenità."
elif [ "$ora" = 13 ]; then
	echo "La CPU è in pausa pranzo."
elif [ "$number" = 0 ]; then
	echo "In questa shell e' severamente vietato fumare."
elif [ "$number" = 1 ]; then
	echo "Prima di utilizzare la tastiera del terminale, siete cortesemente pregati di lavarvi le mani."
elif [ "$number" = 2 ]; then
	echo "La tua faccia non mi e' nuova, straniero..."
elif [ "$number" = 3 ]; then
	echo "Warning: system is going down in 5 minutes."
elif [ "$number" = 4 ]; then
	echo "Qualcosa è andato storSegmentation fault."
elif [ "$number" = 5 ]; then
	echo "Attenzione: Attualmente, su questo sistema, non sono attivi i motori Warp!" 
fi
