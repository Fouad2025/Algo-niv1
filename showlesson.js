let button = document.createElement("button");
button.textContent = "Afficher le cours";
document.body.appendChild(button);

// Create and append the lesson content container
let lessonContent = document.createElement("div");
document.body.appendChild(lessonContent);

function showlesson() {
   
    
    lessonContent.innerHTML = `<p>Le JavaScript, un langage (principalement) côté client
La catégorisation langages statiques / langage dynamique est une première façon de classer les différents langages de programmation.

On peut également classer les différents langages selon l’endroit où ils vont s’exécuter : soit côté client, soit côté serveur.

Pour comprendre ce que sont les langages « côté client » et « côté serveur », il convient avant tout de comprendre ce qu’est un client et ce qu’est un serveur et pour cela il faut savoir ce qu’est un site.

Un site est un ensemble de ressources et de fichiers liés entre eux. Pour que notre site soit accessible sur le web pour tous, on va l’héberger sur un serveur, c’est-à-dire envoyer l’ensemble de nos fichiers sur le serveur et on va également acheter un nom de domaine qui va servir à identifier notre site.

Un « serveur » est une sorte de super ordinateur, constamment accessible et connectés aux autres serveurs (formant ainsi un réseau qu’on appelle le web) et qui va héberger les fichiers constituant un (ou plusieurs) site(s) web et le(s) « servir » sur demande du client.

Lorsqu’on demande à accéder à une page web en tapant une URL dans notre navigateur, nous sommes le client ou plus exactement notre navigateur est le logiciel client qui effectue une demande ou « requête » au serveur qui est la suivante : « sers-moi le fichier correspondant à l’adresse que je t’ai envoyée ».

Les fichiers ou pages d’un site web vont pouvoir être constituées de deux types de codes différents : du code côté serveur et du code côté client. Lorsqu’on demande à un serveur de nous servir une page, celui-ci se charge d’exécuter le code côté client s’il y en a et ne va renvoyer que du code côté client en résultat.

Un langage « côté client » ou « client side » est un langage qui va être exécuté dans le navigateur des utilisateurs qui demandent la page. On peut également appeler ces langages des langages « web » puisqu’ils sont principalement utilisés dans un contexte web.

Il existe aujourd’hui 3 langages côté client incontournables qui sont le HTML, le CSS et le JavaScript.

Les langages côté serveur sont des langages qui vont s’exécuter sur le serveur. Les navigateurs ne sont dans la grande majorité des cas pas capables de comprendre les langages serveur.

Ces langages permettent notamment d’effectuer de manipuler les données pour renvoyer des résultats. Les résultats renvoyés le sont sous forme de code compréhensible par le navigateur (c’est-à-dire du HTML principalement) pour que le navigateur puisse afficher le résultat final.eloppement web. Il permet de rendre les pages web interactives et dynamiques.</p>`;
    button.textContent = "Cacher le cours";
}

function hideLesson() {
    lessonContent.innerHTML = "";
    button.textContent = "Afficher le cours";
}

function toggleContent() {
    
    if (lessonContent.innerHTML === "") {
        showlesson();
    } else {
        hideLesson();
    }
}

button.addEventListener("click", function() {
    toggleContent();
});
