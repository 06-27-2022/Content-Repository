/**
 * You must export types from other modules (files) in order to import them elsewhere.
 */
import {Monster} from './monster';

class Trainer{
    
    //This is a monster array.
    private monsters:Monster[];

    constructor(){
        this.monsters = [new Monster('fire lizard', 100, 50)];
    }
}