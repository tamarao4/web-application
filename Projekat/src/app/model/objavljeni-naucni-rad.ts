import { NaucniRad } from "./naucni-rad";

export interface ObjavljeniNaucniRad {
    id?: number,
    datumObjave: Date
    naucniRad: NaucniRad
    // naucniRad, nastavnici
}
