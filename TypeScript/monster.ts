/**
 * TypeScript is a scripting language that attempts to work
 * around some of the common issues we run into while working
 * with JavaScript. For instance, JavaScript is dynamically
 * typed while TypeScript allows for static typing. It is also
 * the case that TypeScript has classes and interfaces.
 */

 /**
  * Note that if we don't export this class, it cannot be imported
  * elsewhere.
  */
 export class Monster{

    //When declaring a variable, the type must come after the variable name.

    //Access modifiers don't exist in JS, but they exist in TS.
    // private name:string;
    // protected weight:number;
    // height:number;

    //Creating a constructor using the conventional name "constructor".
    //If you declare constructor parameters with access modifiers, they become properties of the class, removing the need to declare them ahead of time.
    constructor(private name:string, private weight:number, private height:number){
        this.name = name;
        this.weight = weight;
        this.height = height;
    }

    //Of course you can also have methods. Note that methods can have dedicated return types.
    getName():string{
        return this.name;
    }

    setName(name:string):void{
        this.name = name;
    }

    /**
     * Methods with "never" as a return type never get a chance to return a value, likely because they throw
     * an error.
     */
    neverReturn():never{
        throw new Error();
    }
 }

 /**
  * Inheritance is supported as well via interfaces and classes.
  */

 interface Catchable{

    //This is an abstract method.
    beCaughtWithPolkaball():void;
 }

 class Polkaman extends Monster implements Catchable{

    beCaughtWithPolkaball():void{
        console.log("This is an implementation of the inherited method.");
    }
 }