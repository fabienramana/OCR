# OCR

Ce projet permet de, à partir d'un fichier texte qui représente des nombres de 0 à 9 sur 3 lignes, de générer un nouveau fichier où sont stockés ces nombres représentés.

J'ai dans un premier temps créé un algorithme qui me permettait de répondre au besoin (en respectant les 4 uses cases cités dans l'énoncé), puis ai effectué un découpage de ce code pour qu'il soit plus
lisible, flexible.

La logique de ce projet est la suivante :

Je lis le fichier texte d'entrée caractère par caractère et stocke chacun de ces caractères dans une cases d'un tableau à double dimension.

Une fois ce traitement terminé, le programme lis 3x3 par 3x3 cases pour déterminer les nombres représentés, puis ils sont ensuite stockés dans une liste.

Suite à cela, le programme parcourt la liste pour afficher les nombres récupérés dans le fichier de résultat sous format texte. 
Sur chaque ligne se trouve 9 nombres, suivis du tag 'ERR' si le calcul du checksum est différent de 0, ou 'ILL' si un nombre n'est pas reconnu (il est remplacé par '?' dans ce cas), ou par rien.

Pour le découpage, j'ai créé deux classes : OCRFile qui permet de lire et de créer les fichiers textes globalement, et RecognizeNumber qui permet de reconnaitre les nombres dans un tableau double dimension.

Concernant les tests, j'en ai créé de manière à gérer tous les cas de figures pour les méthodes de chacune des 2 classes, et ai aussi créé des tests qui reprennent les 4 uses cases cités dans l'énoncé.
