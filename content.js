let divcontent = document.getElementById("content");
let h1 = document.createElement("h1");
h1.classList.add("title");
h1.textContent = "Cours JavaScript";
divcontent.appendChild(h1);
h1.style.color = "blue";
let h2 = document.createElement("h2");
h2.textContent = "Les bases du JavaScript par Eudes KONDA";
h2.style.color = "green";
divcontent.appendChild(h2);
divcontent.innerHTML += `
<p>Le JavaScript est un langage de programmation essentiel pour le développement web. Il permet de rendre les pages web interactives et dynamiques.</p>
`;

