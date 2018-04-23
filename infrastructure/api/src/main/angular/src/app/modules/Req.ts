import {CriteriaImpl} from "./CriteriaImpl";
/**
 * Created by aheroboy on 19/3/2018.
 */
export class Req {
  constructor(public operateType: string,
              public criteria: CriteriaImpl) {
  }
}
