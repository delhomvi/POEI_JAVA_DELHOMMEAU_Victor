class Animations{
    constructor(element) {  
        this.element = element;
    }
    deplacer(x, y){
        this.element.style.position = 'absolute';
        this.element.style.top = `${y}px`;
        this.element.style.left = `${x}px`;
    }
    agrandir(largeur){
        this.element.style.width = `${largeur}%`;
        this.element.style.height = `${largeur}%`;
    }
    changerCouleur(couleur){
        this.element.style.backgroundColor = couleur;
    }
    pivoter(degrees){
        this.element.style.transform = `rotate(${degrees}deg)`;
    }
    disparaitre(){
        this.element.style.display = 'none';
    }
    apparaitre(){
        this.element.style.display = 'block';
    }
    startAnimation(wayToMove){
        let animationInterval;
        var widthOfSpriteSheet = 130;
        var widthOfEachSprite = 32;  
        var position = widthOfEachSprite; //start position for the image
        const speed = 100; //in millisecond(ms)
        const diff = widthOfEachSprite; //difference between two sprites
        setTimeout(clearInterval(animationInterval), 5*1000);
        animationInterval = setInterval(() => {
            this.element.style.backgroundPosition = `-${position}px ${wayToMove}px`;
            if (position < widthOfSpriteSheet) {
                position = position + diff;
            } else {
            position = widthOfEachSprite;
            }
        }, speed);
    }
}