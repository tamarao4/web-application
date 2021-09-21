import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RealizacijaPredmetaFormComponent } from './realizacija-predmeta-form.component';

describe('RealizacijaPredmetaFormComponent', () => {
  let component: RealizacijaPredmetaFormComponent;
  let fixture: ComponentFixture<RealizacijaPredmetaFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RealizacijaPredmetaFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RealizacijaPredmetaFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
