import { TestBed } from '@angular/core/testing';

import { ObjavljeniNaucniRadService } from './objavljeni-naucni-rad.service';

describe('ObjavljeniNaucniRadService', () => {
  let service: ObjavljeniNaucniRadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ObjavljeniNaucniRadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
